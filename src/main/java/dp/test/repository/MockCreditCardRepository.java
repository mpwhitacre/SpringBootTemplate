package dp.test.repository;

import dp.test.domain.MockCreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface MockCreditCardRepository extends CrudRepository<MockCreditCard, Integer> {
    MockCreditCard findById(int noteId);
    MockCreditCard findByIdAndCardHolderName(int noteId, String author);
    @Transactional
    void deleteById(int id);

}
