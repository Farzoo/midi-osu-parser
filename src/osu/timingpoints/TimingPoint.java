package osu.timingpoints;

public class TimingPoint {

    private int time;
    private int beatLength;
    private int meter;
    private int sampleSet;
    private int sampleIndex;
    private int volume;
    private int uninherited;
    private int effects;

    public TimingPoint(int beatLength) {
        this(0, beatLength, 1, 0, 0, 100, 1, 0);
    }

    public TimingPoint(int time, int beatLength, int meter, int sampleSet, int sampleIndex, int volume, int uninherited, int effects) {
        this.time = time;
        this.beatLength = beatLength;
        this.meter = meter;
        this.sampleSet = sampleSet;
        this.sampleIndex = sampleIndex;
        this.volume = volume;
        this.uninherited = uninherited;
        this.effects = effects;
    }

    @Override
    public String toString() {
        return this.time+","+this.beatLength+","+this.meter+","+this.sampleSet+","+this.sampleIndex+","+this.volume+","+this.uninherited+","+this.effects;
    }
}
