package midi.reader;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class Note {

    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;

    private MidiEvent event;
    private int octave;
    private NoteName noteName;

    public Note(MidiEvent event) throws InvalidEventException {
        this.setEvent(event);
    }

    public void setEvent(MidiEvent event) throws InvalidEventException {
        if(!(event.getMessage() instanceof ShortMessage))
            throw new InvalidEventException("This event is not a ShortMessage. It should be related to a note event.");
        ShortMessage sm = (ShortMessage) event.getMessage();
        int data = sm.getCommand();
        if(data != NOTE_OFF && data != NOTE_ON)
            throw new InvalidEventException("This event is not related to key pressing.");
        this.event = event;
        int key = sm.getData1();
        this.octave = (key / 12)-1;
        this.noteName = NoteName.valueOfIntNote(key % 12);
    }

    public long getTick() {
        return this.event.getTick();
    }

    public int getOctave() {
        return this.octave;
    }

    private NoteName getNoteName() {
        return this.noteName;
    }

    public boolean isOn() {
        return ((ShortMessage)this.event.getMessage()).getCommand() == NOTE_ON;
    }

    public boolean sameNote(Note note) {
        return this.getNoteName() == note.getNoteName();
    }

    public boolean sameKey(Note note) {
        return this.getNoteName() == note.getNoteName() && this.getOctave() == note.getOctave();
    }

    @Override
    public String toString() {
        return noteName.toString() + this.octave;
    }
}
