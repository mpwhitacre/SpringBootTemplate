package dp.test.controller;

import dp.test.domain.MockCreditCard;

import dp.test.service.MockCreditCardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MockCreditCardController {

    private static final Logger logger = LogManager.getLogger(MockCreditCard.class);

    @Autowired
    private MockCreditCardService mockCreditCardService;


    @GetMapping(path = "/alive", produces = "text/plain")
    public ResponseEntity<String> isAlive() {
        String result = "alive";
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping(path="/add", produces="application/json")
    public ResponseEntity<HttpStatus> add(@RequestBody MockCreditCard mockCreditCard){
        try {
            if(mockCreditCardService.doesExist(mockCreditCard)){
                MockCreditCard mockCreditCardToDelete = mockCreditCardService.getExisting(mockCreditCard);
                mockCreditCardService.deleteById(mockCreditCardToDelete.getId());
            } else {
               mockCreditCardService.save(mockCreditCard);
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<MockCreditCard> getAllNotes(){
        return mockCreditCardService.findAll();
    }

    @GetMapping(path="/card")
    public @ResponseBody
    MockCreditCard getNote(@RequestParam(value="id") int id){
        return mockCreditCardService.getById(id);
    }

    @DeleteMapping(path="/delete")
    public ResponseEntity<String> deleteNote(@RequestParam(value="id") int id) {
        mockCreditCardService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted.");
    }

}
