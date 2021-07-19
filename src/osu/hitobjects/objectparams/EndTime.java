package osu.hitobjects.objectparams;

public class EndTime implements ObjectParams {

    private int endTime;

    public EndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    @Override
    public String toString() {
        return this.endTime+"";
    }

}
