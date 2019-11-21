package datapuddle.controller;

import datapuddle.service.NoteService;
import datapuddle.domain.Note;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

    private static final Logger logger = LogManager.getLogger(NoteController.class);

    @Autowired
    private NoteService noteService;


    @GetMapping(path = "/alive", produces = "text/plain")
    public ResponseEntity<String> isAlive() {
        String result = "alive";
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping(path="/add", produces="application/json")
    public ResponseEntity<HttpStatus> add(@RequestBody Note note){
        try {
            if(noteService.doesExist(note)){
                Note NoteToDelete = noteService.getExisting(note);
                noteService.deleteById(NoteToDelete.getNoteId());
            } else {
                noteService.save(note);
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Note> getAllNotes(){
        return noteService.findAll();
    }


    @GetMapping(path="/note")
    public @ResponseBody Note getNote(@RequestParam(value="id") int noteId){
        return noteService.getByNoteId(noteId);
    }


    @DeleteMapping(path="/delete")
    public ResponseEntity<String> deleteNote(@RequestParam(value="id") int noteId) {
        noteService.deleteById(noteId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted.");
    }

}
