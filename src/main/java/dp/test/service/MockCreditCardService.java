package dp.test.service;

import dp.test.domain.MockCreditCard;

public interface MockCreditCardService {
    Iterable<MockCreditCard> findAll();
    MockCreditCard getById(int id);
    MockCreditCard save(MockCreditCard mockCreditCard);
    MockCreditCard getExisting(MockCreditCard mockCreditCard);
    boolean doesExist(MockCreditCard mockCreditCard);
    void deleteById(int id);

}
