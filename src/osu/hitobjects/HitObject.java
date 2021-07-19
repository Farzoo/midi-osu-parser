package osu.hitobjects;

import osu.hitobjects.objectparams.ObjectParams;

public class HitObject {
    private int x, y;
    private int time;
    private int type;
    private int hitSound;
    private ObjectParams objectParams;
    private HitSample hitSample;

    public HitObject(int x, int y, int time, int type, int hitSound, ObjectParams objectParams, HitSample hitSample) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.type = type;
        this.hitSound = hitSound;
        this.objectParams = objectParams;
        this.hitSample = hitSample;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTime() {
        return time;
    }

    public int getType() {
        return type;
    }

    public int getHitSound() {
        return hitSound;
    }

    public ObjectParams getObjectParams() {
        return objectParams;
    }

    public HitSample getHitSample() {
        return hitSample;
    }

    public boolean sameX(HitObject hitObj) {
        return this.getX() == hitObj.getX();
    }

    public boolean sameY(HitObject hitObj) {
        return this.getY() == hitObj.getY();
    }

    public boolean sameCoordinates(HitObject hitObj) {
        return this.sameX(hitObj) && this.sameY(hitObj);
    }

    public String toString() {
        String objParams;
        if(this.objectParams == null)
            objParams = "";
        else
            objParams = this.objectParams + ",";
        return this.x+","+this.y+","+this.time+","+this.type+","+this.hitSound+","+objParams+this.hitSample.toString();
    }


}
