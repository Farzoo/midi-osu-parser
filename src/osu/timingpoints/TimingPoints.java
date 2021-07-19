package osu.timingpoints;

import java.util.ArrayList;

public class TimingPoints {

    private ArrayList<TimingPoint> timingPoints;

    public TimingPoints() {
        this.timingPoints = new ArrayList<>();
        this.timingPoints.add(new TimingPoint(300));
    }

    public void add(TimingPoint tp) {
        this.timingPoints.add(tp);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("[TimingPoints]\n");
        for(TimingPoint tp : timingPoints) {
            sb.append(tp.toString()).append("\n");
        }
        return sb.toString();
    }
}
