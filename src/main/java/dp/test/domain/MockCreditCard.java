package dp.test.domain;

import javax.persistence.*;

@Entity
@Table(name="MOCK_CREDIT_CARDS")
public class MockCreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    int id;
    @Column(name="CREDIT_CARD_NUMBER")
    int cardNumber;
    @Column(name="CARD_HOLDER_NAME")
    String cardHolderName;
    @Column(name="EXPIRATION_MONTH")
    int expirationMonth;
    @Column(name="EXPIRATION_YEAR")
    int expirationYear;
    @Column(name="CVV")
    int cvv;

    public MockCreditCard(){}

    public MockCreditCard(int cardNumber, String cardHolderName, int expirationMonth, int expirationYear, int cvv){
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.cvv = cvv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
