package dp.test.service;

import dp.test.domain.Note;

public interface NoteService {
    Iterable<Note> findAll();
    Note getByNoteId(int noteId);
    Note save(Note note);
    Note getExisting(Note note);
    boolean doesExist(Note note);
    void deleteById(int id);

}
