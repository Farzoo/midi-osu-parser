package osu.hitobjects.objectparams;

import java.util.ArrayList;

public class SliderParams implements ObjectParams {
    private char curveType;
    private ArrayList<CurvePoint> curvePoints = new ArrayList<>();

    public SliderParams(char curveType, ArrayList<CurvePoint> curvePoints) {
        this.curveType = curveType;
        this.curvePoints = curvePoints;
    }

    public char getCurveType() {
        return curveType;
    }

    public CurvePoint getCurvePoint(int i) {
        return this.curvePoints.get(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.curveType+"|");
        for(CurvePoint cp : this.curvePoints) {
            sb.append(cp.toString()+"|");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
