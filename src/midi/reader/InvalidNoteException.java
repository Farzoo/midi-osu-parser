package midi.reader;

public class InvalidNoteException extends Exception {

    private Note note;
    public InvalidNoteException(Note note, String message) {
        super(message);
    }

    @Override
    public String toString() {
        return note.toString() + "." + super.toString();
    }
}
