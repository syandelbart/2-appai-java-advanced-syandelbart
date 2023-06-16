package fact.it.ex1.model;

import javax.persistence.Entity;

@Entity
public class AmexPayment extends ElectronicPayment {
    private int pinCode;

    public AmexPayment() {
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
