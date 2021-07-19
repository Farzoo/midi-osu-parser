package osu.events;

public class Background extends Event {

    private String filename;
    private int xOffSet;
    private int yOffSet;

    public Background() {
        this("", 0, 0);
    }

    public Background(String filename) {
        this(filename, 0, 0);
    }

    public Background(String filename, int xOffSet, int yOffSet) {
        super(0);
        this.filename = filename;
        this.xOffSet = xOffSet;
        this.yOffSet = yOffSet;
    }

    public String getFilename() {
        return this.filename;
    }

    public int getType() {
        return 0;
    }

    @Override
    public String toString() {
        return this.getType()+","+this.getStartTime()+","+this.getFilename()+","+this.xOffSet+","+this.yOffSet;
    }
}
