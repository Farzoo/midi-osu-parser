package midi.reader;

import java.util.HashMap;

public enum NoteName {
    C(0, false),
    C_SHARP(1, true),
    D(2, false),
    D_SHARP(3, true),
    E(4, false),
    F(5, false),
    F_SHARP(6, true),
    G(7, false),
    G_SHARP(8, true),
    A(9, false),
    A_SHARP(10, true),
    B(11, false);

    private static final HashMap<Integer, NoteName> BY_INT_NOTE = new HashMap<>();

    static {
        for(NoteName note : values())
            BY_INT_NOTE.put(note.note, note);
    }

    private boolean isSharp;
    private int note;

    NoteName(int note, boolean isSharp) {
        this.note = note;
        this.isSharp = isSharp;
    }

    public boolean sameNoteName(NoteName noteName) {
        return this == noteName;
    }

    public static NoteName valueOfIntNote(int note) {
        return BY_INT_NOTE.get(note);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(String.valueOf(this.name().charAt(0)));
        if(this.isSharp) {
            sb.append("#");
        }
        return sb.toString();
    }
}
