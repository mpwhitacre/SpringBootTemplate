package datapuddle.repository;

import datapuddle.domain.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface NoteRepository extends CrudRepository<Note, Integer> {
    Note findByNoteId(int noteId);
    Note findByNoteIdAndAuthor(int noteId, String author);
    @Transactional
    void deleteById(int id);

}
