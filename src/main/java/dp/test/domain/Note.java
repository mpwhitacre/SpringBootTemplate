package dp.test.domain;

import javax.persistence.*;

@Entity
@Table(name="NOTES")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    int noteId;
    @Column(name="AUTHOR")
    String author;
    @Column(name="NOTE")
    String note;

    public Note(){}

    public Note(String author, String note){
        this.author = author;
        this.note = note;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString(){
        return "Note{" + "noteId=" + noteId + ", author='" + author + '\'' + ", note='" + note + '\'' + '}';

    }
}
