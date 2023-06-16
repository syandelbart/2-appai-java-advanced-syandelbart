package fact.it.refuelling.model;

public class Refuelling {
    private int id;
    private int previousMileage;
    private int currentMileage;
    private double amountInLitres;

    Refuelling(int id, int previousMileage, int currentMileage, double amountInLitres) {
        this.id = id;
        this.previousMileage = previousMileage;
        this.currentMileage = currentMileage;
        this.amountInLitres = amountInLitres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreviousMileage() {
        return previousMileage;
    }

    public void setPreviousMileage(int previousMileage) {
        this.previousMileage = previousMileage;
    }

    public int getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(int currentMileage) {
        this.currentMileage = currentMileage;
    }

    public double getAmountInLitres() {
        return amountInLitres;
    }

    public void setAmountInLitres(double amountInLitres) {
        this.amountInLitres = amountInLitres;
    }

    public double getFuelConsumption() {
        return this.amountInLitres / ((this.currentMileage - this.previousMileage) / 100);
    }
}
