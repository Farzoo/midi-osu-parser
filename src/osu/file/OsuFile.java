package osu.file;

import osu.colours.Colours;
import osu.difficulty.Difficulty;
import osu.editor.Editor;
import osu.events.Background;
import osu.events.Events;
import osu.general.General;
import osu.hitobjects.HitObject;
import osu.hitobjects.HitObjects;
import osu.hitobjects.HitSample;
import osu.hitobjects.objectparams.ObjectParams;
import osu.metadata.Metadata;
import osu.timingpoints.TimingPoint;
import osu.timingpoints.TimingPoints;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OsuFile {
    public static final String VERSION = "osu file format v14";
    public static final String AUTHOR = "OsuAutoMapper";

    protected String title;
    protected String bg;

    protected General general;
    protected Editor editor;
    protected Metadata metadata;
    protected Difficulty difficulty;
    protected Events events;
    protected TimingPoints timingPoints;
    protected Colours colours;
    protected HitObjects hitObjects;

    public OsuFile(String title, int beatLength, float hpDrainRate, float circleSize, float overallDifficulty, float ar, float sliderMultiplier, float sliderTickRate) {
        this.title = title;
        this.general = new General("virtual", 0, 0, false, "None", 0.7f, getMode(), false, false);
        this.editor = new Editor();
        this.metadata = new Metadata(title);
        this.metadata.setCreator(OsuFile.AUTHOR);
        this.setDifficulty(hpDrainRate, circleSize, overallDifficulty, ar, sliderMultiplier, sliderTickRate);
        this.events = new Events();
        this.events.addEvent(new Background("bg.png"));
        this.bg = "bg.png";
        this.timingPoints = new TimingPoints();
        this.colours = new Colours();
        this.hitObjects = new HitObjects();
    }

    public OsuMode getMode() {
        return OsuMode.DEFAULT;
    }

    protected void setDifficulty(float hpDrainRate, float circleSize, float overallDifficulty, float ar, float sliderMultiplier, float sliderTickRate) {
        this.difficulty = new Difficulty(hpDrainRate, circleSize, overallDifficulty, ar, sliderMultiplier, sliderTickRate);
    }

    public void addHitObject(int x, int y, int time, int type, int hitSound, ObjectParams objectParams, HitSample hitSample) {
        this.hitObjects.putHitObject(time, new HitObject(x, y, time, type, hitSound, objectParams, hitSample));
    }

    public String getTitle() {
        return this.title;
    }

    public void createOsuFolder(String path) throws IOException {
        System.out.println(getTitle());
        File folder = new File(path+OsuFile.AUTHOR + " " + this.getTitle());
        if (!folder.exists()) {
            folder.mkdir();
        } else if(!folder.isDirectory() || folder.listFiles().length > 0) {
            throw new FileAlreadyExistsException("The folder already exists or is not empty.");
        }
        this.writeToFile(folder.getPath()+"/");
        Files.copy(Paths.get("./resources/osu/bg.jpg"), Paths.get(folder.getPath()+"/bg.png"));
        System.out.println(this.hitObjects.getAllHitSample());
        for(HitSample hitSample : this.hitObjects.getAllHitSample()) {
            Files.copy(Paths.get("./resources/samples/"+hitSample.getFilename()), Paths.get(folder.getPath()+"/"+hitSample.getFilename()));
        }
    }

    public void writeToFile(String folder_path) {
        try {
            System.out.println(folder_path+this.getTitle()+".osu");
            BufferedWriter bw = new BufferedWriter(new FileWriter(folder_path+this.getTitle()+".osu"));
            bw.write(this.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return OsuFile.VERSION + "\n\n" +
                this.general + "\n" +
                this.editor + "\n" +
                this.metadata + "\n" +
                this.difficulty + "\n" +
                this.events + "\n" +
                this.timingPoints + "\n" +
                this.colours + "\n" +
                this.hitObjects + "\n";

    }
}
