package osu.events;

public class Video extends Background {

    public Video() {
        this(0, "", 0, 0);
    }

    public Video(String filename) {
        this(0, filename, 0, 0);
    }

    public Video(int startTime, String filename, int xOffset, int yOffset) {
        super(filename, xOffset, yOffset);
        this.setStartTime(startTime);
    }

    @Override
    public int getType() {
        return 1;
    }

    public String toString() {
        return super.toString();
    }
}
