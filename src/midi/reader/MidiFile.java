package midi.reader;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class MidiFile {

    private String title;
    private Sequence sequence;
    private TreeMap<Long, ArrayList<KeyPress>> allKeyPress = new TreeMap<>(Long::compare);

    public MidiFile(File file) throws InvalidMidiDataException, IOException {
        this.title = file.getName().substring(0, file.getName().length()-4);
        this.sequence = MidiSystem.getSequence(file);
        for(Track track : this.sequence.getTracks()) {
            for(int i = 0; i < track.size(); i++) {
                MidiEvent event = track.get(i);
                MidiMessage message = event.getMessage();
                if(message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    if(sm.getCommand() == ShortMessage.NOTE_ON || sm.getCommand() == ShortMessage.NOTE_OFF) {
                        int velocity = ((ShortMessage) message).getData2();
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        if(octave > 0 && (key < 109)) {
                            if (velocity == 0) {
                                ((ShortMessage) message).setMessage(ShortMessage.NOTE_OFF, ((ShortMessage) message).getData1(), 0);
                            }
                            try {
                                this.put(new Note(event));
                            } catch (InvalidEventException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    TreeMap<Long, ArrayList<KeyPress>> getAllKeyPress() {
        return this.allKeyPress;
    }

    public long getDurationInMs() {
        return (long) (this.sequence.getMicrosecondLength() / Math.pow(10, 3));
    }

    public long getDurationEventInMs(MidiEvent event) {
        return (long)(this.getDurationInMs() * (event.getTick() / (float)this.sequence.getTickLength()));
    }

    public long getDurationEventInMs(Note note) {
        return (long)(this.getDurationInMs() * (note.getTick() / (float)this.sequence.getTickLength()));
    }

    public String getTitle() {
        return this.title;
    }

    public void put(Note note) {
        if(note.isOn()) {
            try {
                if(this.allKeyPress.containsKey(this.getDurationEventInMs(note))) {
                    this.allKeyPress.get(this.getDurationEventInMs(note)).add(new KeyPress(note));
                } else {
                    ArrayList<KeyPress> temp = new ArrayList<>();
                    temp.add(new KeyPress(note));
                    this.allKeyPress.put(this.getDurationEventInMs(note), temp);
                }
            } catch (InvalidNoteException e) {
                e.printStackTrace();
            }
        } else {
            for(ArrayList<KeyPress> keyPressList : this.allKeyPress.values()) {
                for(KeyPress keyPress : keyPressList) {
                    if(keyPress.getNoteOff() == null) {
                        if(keyPress.getNoteOn().sameKey(note)) {
                            try {
                                keyPress.setNoteOff(note);
                            } catch (InvalidNoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Title : " + this.title +
                "\nDuration : " + this.getDurationInMs() + "ms" +
                "\n" + allKeyPress +
                '}';
    }
}
