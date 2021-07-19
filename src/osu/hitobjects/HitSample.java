package osu.hitobjects;

import java.util.Objects;

public class HitSample {
    private int normalSet;
    private int additionSet;
    private int index;
    private int volume;
    private String filename;

    public HitSample(String filename) {
        this.normalSet = 0;
        this.additionSet = 0;
        this.index = 0;
        this.volume = 0;
        this.filename = filename;
    }

    public HitSample(int normalSet, int additionSet, int index, int volume, String filename) {
        this.normalSet = normalSet;
        this.additionSet = additionSet;
        this.index = index;
        this.volume = volume;
        this.filename = filename;
    }

    public int getNormalSet() {
        return this.normalSet;
    }

    public int getAdditionSet() {
        return this.additionSet;
    }

    public int getIndex() {
        return this.index;
    }

    public int getVolume() {
        return this.volume;
    }

    public String getFilename() {
        return this.filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HitSample hitSample = (HitSample) o;
        return normalSet == hitSample.normalSet && additionSet == hitSample.additionSet && index == hitSample.index && volume == hitSample.volume && filename.equals(hitSample.filename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(normalSet, additionSet, index, volume, filename);
    }

    @Override
    public String toString() {
        return normalSet+":"+additionSet+":"+index+":"+volume+":"+filename;
    }
}
