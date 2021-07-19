package osu.difficulty;

public class Difficulty {
    private float hpDrainRate;
    private float circleSize;
    private float overallDifficulty;
    private float approachRate;
    private float sliderMultiplier;
    private float sliderTickRate;

    public Difficulty() {
        this.hpDrainRate = 5;
        this.circleSize = 3;
        this.overallDifficulty = 6;
        this.approachRate = 10;
        this.sliderMultiplier = 1.4f;
        this.sliderTickRate = 1;
    }

    public Difficulty(float hpDrainRate, float circleSize, float overallDifficulty, float approachRate, float sliderMultiplier, float sliderTickRate) {
        this.hpDrainRate = hpDrainRate;
        this.circleSize = circleSize;
        this.overallDifficulty = overallDifficulty;
        this.approachRate = approachRate;
        this.sliderMultiplier = sliderMultiplier;
        this.sliderTickRate = sliderTickRate;
    }



    public String toString() {
        return "[Difficulty]\n" +
                "HPDrainRate: " + this.hpDrainRate + "\n" +
                "CircleSize: " + this.circleSize + "\n" +
                "OverallDifficulty: " + this.overallDifficulty + "\n" +
                "ApproachRate: " + this.approachRate + "\n" +
                "SliderMultiplier: " + this.sliderMultiplier + "\n" +
                "SliderTickRate: " + this.sliderTickRate + "\n";
    }
}
