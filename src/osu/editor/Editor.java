package osu.editor;

public class Editor {
    private float distanceSnaping = 1.22f;
    private int beatDivisor = 4;
    private int gridSize = 4;
    private int timelineZoom = 1;

    public Editor() {

    }

    public Editor(float distanceSnaping, int beatDivisor, int gridSize, int timelineZoom) {
        this.distanceSnaping = distanceSnaping;
        this.beatDivisor = beatDivisor;
        this.gridSize = gridSize;
        this.timelineZoom = timelineZoom;
    }

    public String toString() {
        return "[Editor]\n" +
                "DistanceSpacing: " + this.distanceSnaping + "\n" +
                "BeatDivisor: " + this.beatDivisor + "\n" +
                "GridSize: " + this.gridSize + "\n" +
                "TimelineZoom: " + this.timelineZoom + "\n";
    }
}
