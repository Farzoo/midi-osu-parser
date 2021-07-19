package midi.reader;

public class KeyPress {

    private Note noteOn;
    private Note noteOff;

    public KeyPress(Note note) throws InvalidNoteException {
        this.setNoteOn(note);
    }

    public void setNoteOn(Note note) throws InvalidNoteException {
        if(!note.isOn())
            throw new InvalidNoteException(note, "Should be a note on.");
        this.noteOn = note;
    }

    public void setNoteOff(Note note) throws InvalidNoteException {
        if(note.isOn())
            throw new InvalidNoteException(note, "Should be a note off");
        if(!note.sameKey(this.noteOn))
            throw new InvalidNoteException(note, "The note off should be the same key as the note on.");
        if(note.getTick() < this.noteOn.getTick())
            throw new InvalidNoteException(note, "The note off event should be after the note on event");
        this.noteOff = note;
    }

    public long getDeltaTick() {
        return this.noteOff.getTick() - this.noteOn.getTick();
    }

    public Note getNoteOn() {
        return this.noteOn;
    }

    public Note getNoteOff() {
        return this.noteOff;
    }

    @Override
    public String toString() {
        return this.noteOn + "= (" + this.noteOn.getTick() + ", " + this.noteOff.getTick() + ")"  ;
    }
}
