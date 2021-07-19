package osu.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OsuAutoMapper {

    private static final String OSU_PATH = "./osu_path.txt";
    private static final String autoMapperSongsFolderName = "/OsuAutoMapper/";
    private File osuFolder;
    private File autoMapperFolder;

    public OsuAutoMapper() throws FileNotFoundException {
        this(getOsuPath());
    }

    private OsuAutoMapper(File osuFolder) throws FileNotFoundException {
        if(osuFolder == null)
            throw new FileNotFoundException("The file does not exist");
        if(!osuFolder.isDirectory())
            throw new FileNotFoundException(osuFolder.getAbsolutePath() + ". The file should be a folder.");
        if(!osuFolder.getName().equals("osu!"))
            throw new FileNotFoundException(osuFolder.getAbsolutePath() + ". The file does not correspond to the osu! folder.");
        this.osuFolder = osuFolder;
        this.autoMapperFolder = new File(osuFolder, "/Songs/"+autoMapperSongsFolderName);
        this.createOsuFolder();
    }

    private OsuAutoMapper(String osuFolder) throws FileNotFoundException {
        this(new File(osuFolder));

    }

    public static File getOsuPath() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(OsuAutoMapper.OSU_PATH));
            String path = br.readLine();
            br.close();
            return new File(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addOsuFile(OsuFile osuFile) {
        System.out.println(osuFile.getTitle());
        File file = new File(this.osuFolder.getPath()+"/Songs/"+autoMapperSongsFolderName+osuFile.getTitle());
        if(!file.exists())
            osuFile.writeToFile(this.osuFolder.getPath()+"/Songs/"+autoMapperSongsFolderName);
    }

    public void createOsuFolder() {
        File songsFolder = new File(this.osuFolder, "/Songs");
        File autoMapperFolder = new File(this.osuFolder, "/Songs/"+autoMapperSongsFolderName);
        autoMapperFolder.mkdir();
        File samplesFolder = new File("./resources/samples/");
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".wav");
            }
        };
        File copiedBg = new File(autoMapperFolder.getPath() + "/bg.png");
        if(!copiedBg.exists()) {
            try {
                Files.copy(Paths.get("./resources/osu/bg.jpg"), Paths.get(copiedBg.getPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(File sample : samplesFolder.listFiles(filter)) {
            File copiedSample = new File(autoMapperFolder.getPath() + "/" + sample.getName());
            if(!copiedSample.exists()) {
                try {
                    Files.copy(Paths.get(sample.getPath()), Paths.get(copiedSample.getPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
