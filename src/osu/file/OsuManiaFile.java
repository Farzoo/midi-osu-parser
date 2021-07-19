package osu.file;

import osu.hitobjects.HitObject;
import osu.hitobjects.HitSample;
import osu.hitobjects.objectparams.ObjectParams;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public final class OsuManiaFile extends OsuFile{

    private int[] xPos;
    private int keyCount;

    public OsuManiaFile(String title, int beatLength, float hpDrainRate, int keyCount, float overallDifficulty) {
        super(title, beatLength, hpDrainRate, keyCount, overallDifficulty, 5, 1.4f, 1);
        this.keyCount = keyCount;
        this.generateXPos();
    }

    @Override
    public OsuMode getMode() {
        return OsuMode.MANIA;
    }

    public void generateXPos() {
        this.xPos = new int[this.keyCount];
        for(int i = 0; i < this.keyCount; i++) {
            this.xPos[i] = (int) Math.floor((float)(i+1)/((float)this.keyCount/(float)512))-30;
        }
    }

    public String getTitle() {
        return this.title + " " + this.keyCount+"k";
    }

    public int[] getxPos() {
        return xPos;
    }

    @Override
    protected void setDifficulty(float hpDrainRate, float keyCount, float overallDifficulty, float ar, float sliderMultiplier, float sliderTickRate) {
        super.setDifficulty(hpDrainRate, keyCount, overallDifficulty, ar, sliderMultiplier, sliderTickRate);
    }

    public void addHitObject(int time, int type, int hitSound, ObjectParams objectParams, HitSample hitSample) {
        HashSet<Integer> testedXPos = new HashSet<>();
        int column = chooseRandomColumn();
        while(testedXPos.size() < this.xPos.length && !this.hitObjects.putHitObject(time, new HitObject(column, 192, time, type, hitSound, objectParams, hitSample))) {
            testedXPos.add(column);
            column = chooseRandomColumn();
        }
    }

    public int chooseRandomColumn() {
        return this.xPos[(int)(Math.random()*this.keyCount)];
    }
}
