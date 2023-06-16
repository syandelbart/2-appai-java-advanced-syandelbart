package fact.it.refuelling.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefuellingTest {

    @Test
    void getId() {
        Refuelling refuelling = new Refuelling(123,15,30,50);

        assertEquals(123,refuelling.getId());
    }

    @Test
    void setId() {
        Refuelling refuelling = new Refuelling(123,15,30,50);
        refuelling.setId(1234);

        assertEquals(1234,refuelling.getId());
    }

    @Test
    void getPreviousMileage() {
        Refuelling refuelling = new Refuelling(123,15,30,50);

        assertEquals(15,refuelling.getPreviousMileage());
    }

    @Test
    void setPreviousMileage() {
        Refuelling refuelling = new Refuelling(123,15,30,50);
        refuelling.setPreviousMileage(154);

        assertEquals(154,refuelling.getPreviousMileage());
    }

    @Test
    void getCurrentMileage() {
        Refuelling refuelling = new Refuelling(123,15,30,50);

        assertEquals(30,refuelling.getCurrentMileage());
    }

    @Test
    void setCurrentMileage() {
        Refuelling refuelling = new Refuelling(123,15,30,50);
        refuelling.setCurrentMileage(50);

        assertEquals(50,refuelling.getCurrentMileage());
    }

    @Test
    void getAmountInLitres() {
        Refuelling refuelling = new Refuelling(123,15,30,50);

        assertEquals(50,refuelling.getAmountInLitres());
    }

    @Test
    void setAmountInLitres() {
        Refuelling refuelling = new Refuelling(123,15,30,70);
        refuelling.setAmountInLitres(70);

        assertEquals(70,refuelling.getAmountInLitres());
    }

    @Test
    void getFuelConsumption() {
        int previousMileage = 90;
        int currentMileage = 1780;
        int amountInLitres = 120;
        Refuelling refuelling = new Refuelling(123,previousMileage,currentMileage,amountInLitres);

        assertEquals((double) amountInLitres / ((currentMileage - previousMileage) / 100),refuelling.getFuelConsumption());


    }
}