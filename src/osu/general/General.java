package osu.general;

import osu.file.OsuMode;

import java.io.File;

public class General {
    private String audioFile;
    private int audioLeadIn;
    private int previewTime;
    private boolean countDown;
    private String sampleSet;
    private float stackLeniency;
    private OsuMode mode;
    private boolean letterboxInBreaks;
    private boolean widescreenStoryboard;

    public General(String audioFile, int audioLeadIn, int previewTime, boolean countDown, String sampleSet,
                   float stackLeniency, OsuMode mode, boolean letterboxInBreaks, boolean widescreenStoryboard) {
        this.audioFile = audioFile;
        this.audioLeadIn = audioLeadIn;
        this.previewTime = previewTime;
        this.countDown = countDown;
        this.sampleSet = sampleSet;
        this.stackLeniency = stackLeniency;
        this.mode = mode;
        this.letterboxInBreaks = letterboxInBreaks;
        this.widescreenStoryboard = widescreenStoryboard;
    }

    @Override
    public String toString() {
        return "[General]\n" +
                "AudioFilename: " + this.audioFile + "\n" +
                "AudioLeadIn: " + this.audioLeadIn + "\n" +
                "PreviewTime: " + this.previewTime + "\n" +
                "Countdown: " + (this.countDown ? 1 : 0) + "\n" +
                "SampleSet: " + this.sampleSet + "\n" +
                "StackLeniency: " + this.stackLeniency + "\n" +
                "Mode: " + this.mode.getMode() + "\n" +
                "LetterboxInBreaks: " + (this.letterboxInBreaks ? 1 : 0) + "\n" +
                "WidescreenStoryboard: " + (this.widescreenStoryboard ? 1 : 0) + "\n";
    }

}
