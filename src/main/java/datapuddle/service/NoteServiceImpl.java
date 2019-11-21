package datapuddle.service;

import datapuddle.repository.NoteRepository;
import datapuddle.domain.Note;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class NoteServiceImpl implements NoteService {
    private static final Logger logger = LogManager.getLogger(NoteServiceImpl.class);

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note getByNoteId(int noteId) {
        try {
            return noteRepository.findByNoteId(noteId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public Note save(Note note) {
        try {
            return noteRepository.save(note);
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        try {
            noteRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }


    @Override
    public boolean doesExist(Note note) {
        return noteRepository.existsById(note.getNoteId());
    }


    @Override
    public Note getExisting(Note note){
        return noteRepository.findByNoteIdAndAuthor(note.getNoteId(), note.getAuthor());
    }


    @Override
    public Iterable<Note> findAll(){
        return noteRepository.findAll();
    }
}
