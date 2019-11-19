package dp.test.service;

import dp.test.domain.MockCreditCard;

import dp.test.repository.MockCreditCardRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class MockCreditCardServiceImpl implements MockCreditCardService {
    private static final Logger logger = LogManager.getLogger(MockCreditCardServiceImpl.class);

    @Autowired
    private MockCreditCardRepository mockCreditCardRepository;

    @Override
    public MockCreditCard getById(int id) {
        try {
            return mockCreditCardRepository.findById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public MockCreditCard save(MockCreditCard mockCreditCard) {
        try {
            return mockCreditCardRepository.save(mockCreditCard);
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        try {
            mockCreditCardRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }


    @Override
    public boolean doesExist(MockCreditCard mockCreditCard) {
        return mockCreditCardRepository.existsById(mockCreditCard.getId());
    }


    @Override
    public MockCreditCard getExisting(MockCreditCard mockCreditCard){
        return mockCreditCardRepository.findByIdAndCardHolderName(mockCreditCard.getId(), mockCreditCard.getCardHolderName());
    }


    @Override
    public Iterable<MockCreditCard> findAll(){
        return mockCreditCardRepository.findAll();
    }
}
