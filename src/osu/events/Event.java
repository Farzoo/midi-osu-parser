package osu.events;

public abstract class Event {

    private int startTime;

    public Event(int startTime) {
        this.startTime = startTime;
    }

    public int getStartTime() {
        return this.startTime;
    }

    protected void setStartTime(int time) {
        this.startTime = time;
    }

    @Override
    public String toString() {
        return startTime + "";
    }
}
