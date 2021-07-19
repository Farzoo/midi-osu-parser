package osu.hitobjects.objectparams;

public class CurvePoint {
    private int x, y;

    public CurvePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.x+":"+this.y;
    }
}
