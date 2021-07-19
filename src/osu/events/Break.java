package osu.events;

public class Break extends Event {
    private int endTime;

    public Break() {
        this(0, 0);
    }

    public Break(int startTime, int endTime) {
        super(startTime);
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Break,"+this.getStartTime()+","+this.endTime;
    }
}
