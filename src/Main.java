import midi.reader.MidiFile;
import midi.reader.MidiFileParser;
import osu.file.OsuAutoMapper;
import osu.file.OsuManiaFile;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String midiPath = "";
        try {
            OsuAutoMapper osuAutoMapper = new OsuAutoMapper();
            MidiFile midiFile = new MidiFile(new File(midiPath));
            OsuManiaFile osuManiaFile = MidiFileParser.parseToOsuManiaFile(midiFile, 5, 4, 8);
            osuAutoMapper.addOsuFile(osuManiaFile);
        } catch (IOException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
}
