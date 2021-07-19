package osu.file;

public enum OsuMode {
    DEFAULT(0),
    TAIKO(1),
    CATCH(2),
    MANIA(3);

    private int mode;

    OsuMode(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return this.mode;
    }
}
