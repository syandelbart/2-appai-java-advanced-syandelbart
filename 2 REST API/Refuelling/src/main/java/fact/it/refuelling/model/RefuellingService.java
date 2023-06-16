package fact.it.refuelling.model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.management.InstanceNotFoundException;
import java.util.*;

public class RefuellingService {

    List<Refuelling> refuellingList;

    public RefuellingService() {
        this.refuellingList = new ArrayList<Refuelling>();

        for (int i = 0; i < 10; i++) {
            this.refuellingList.add(new Refuelling(i,i * 100,(i+1)*100,20 ));
        }
    }

    public Optional<Refuelling> getOptionalRefuellingById(int id) {
        return refuellingList.stream()
                .filter(refuelling -> refuelling.getId() == id)
                .findFirst();
    }

    public List<Refuelling> getRefuellingList() {
        return this.refuellingList;
    }

    public void setRefuellingList(List<Refuelling> refuellingList) {
        this.refuellingList = refuellingList;
    }

    public Refuelling addRefueling(Refuelling refuelling) {
        refuelling.setId(this.refuellingList.size());
        this.refuellingList.add(refuelling);
        return this.refuellingList.get(this.refuellingList.size()-1);
    }

    public Refuelling updateRefuellingById(Refuelling updateRefuelling, int id) {
        Optional<Refuelling> referencedRefuelling = refuellingList.stream()
                .filter(refuelling -> refuelling.getId() == id)
                .findFirst();

        if(referencedRefuelling.isEmpty()) {
            System.out.println("Refuelling with id " + id + " not found.");
            return null;
        }

        //Update the current object with the new information from updateRefuelling
        Refuelling refuellingToUpdate = referencedRefuelling.get();

        refuellingToUpdate.setPreviousMileage(updateRefuelling.getPreviousMileage());
        refuellingToUpdate.setCurrentMileage(updateRefuelling.getCurrentMileage());
        refuellingToUpdate.setAmountInLitres(updateRefuelling.getAmountInLitres());

        return refuellingToUpdate;
    }

    public double getTotalConsumption() {
        return this.refuellingList.stream().map(refuelling -> refuelling.getFuelConsumption()).reduce(0.0,Double::sum);
    }
}
