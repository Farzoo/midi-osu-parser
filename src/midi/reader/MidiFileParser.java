package midi.reader;

import midi.reader.MidiFile;
import osu.file.OsuManiaFile;
import osu.hitobjects.HitSample;

import java.util.ArrayList;
import java.util.Map;

public abstract class MidiFileParser {

    public static OsuManiaFile parseToOsuManiaFile(MidiFile midiFile, float hpDrainRate, int keyCount, float overallDifficulty) {

        OsuManiaFile osuManiaFile = new OsuManiaFile(midiFile.getTitle(), 1, hpDrainRate, keyCount, overallDifficulty);
        for(Map.Entry<Long, ArrayList<KeyPress>> entry : midiFile.getAllKeyPress().entrySet()) {
            /*if(entry.getValue().size() > keyCount) {
                int i = 0;
                while(i < entry.getValue().size() && entry.getValue().size() > keyCount) {

                }
            }*/
            while(entry.getValue().size() > keyCount) {
                entry.getValue().remove(entry.getValue().size()-1);
            }
            for(KeyPress keyPress : entry.getValue()) {
                osuManiaFile.addHitObject(entry.getKey().intValue(), 1, 0, null, new HitSample(keyPress.getNoteOn().toString()+".wav"));
            }
        }
        return osuManiaFile;
    }
}
