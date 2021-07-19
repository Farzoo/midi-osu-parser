package osu.metadata;

public class Metadata {
    private String title;
    private String artist;
    private String creator;
    private String version;
    private String source;
    private String[] tags;
    private int beatmapId;
    private int beatmapSetId;

    public Metadata() {
        this("Unknow", "Unknow", "Unknow", "None", "None", null, 0, 0);
    }

    public Metadata(String title) {
        this(title, "Unknow", "Unknow", "None", "None", null, 0, 0);
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Metadata(String title, String artist, String creator, String version, String source, String[] tags, int beatmapId, int beatmapSetId) {
        this.title = title;
        this.artist = artist;
        this.creator = creator;
        this.version = version;
        this.source = source;
        this.tags = tags;
        this.beatmapId = beatmapId;
        this.beatmapSetId = beatmapSetId;
    }

    public String toString() {
        StringBuilder tags = new StringBuilder();
        if(this.tags != null) {
            for (String tag : this.tags) {
                tags.append(tag).append(" ");
            }
        }
        return "[Metadata]\n" +
                "Title: " + this.title + "\n" +
                "TitleUnicode: " + this.title + "\n" +
                "Artist: " + this.artist + "\n" +
                "ArtistUnicode: " + this.artist + "\n" +
                "Creator: " + this.creator + "\n" +
                "Version: " + this.version + "\n" +
                "Source: " + this.source + "\n" +
                "Tags: " + tags + "\n" +
                "BeatmapID: " + this.beatmapId + "\n" +
                "BeatmapSetID: " + this.beatmapSetId + "\n";
    }
}
