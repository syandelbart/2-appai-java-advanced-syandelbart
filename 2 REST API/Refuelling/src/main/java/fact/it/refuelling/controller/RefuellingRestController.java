package fact.it.refuelling.controller;

import fact.it.refuelling.model.Refuelling;
import fact.it.refuelling.model.RefuellingService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RefuellingRestController {
    private RefuellingService refuellingService;

    @PostConstruct
    public void fillRefuellingServiceWithRefuellings() {
        refuellingService = new RefuellingService();
    }

    @GetMapping("/refuellings")
    public List<Refuelling> getAllRefuellings() {
        return refuellingService.getRefuellingList();
    }

    @GetMapping("/refuelling/{id}")
    public ResponseEntity<Refuelling> getRefuelling(@PathVariable("id") int id) {
        Optional<Refuelling> refuelling = refuellingService.getOptionalRefuellingById(id);

        if(refuelling.isPresent()) {
            return new ResponseEntity<>(refuelling.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/refuellings/add")
    public ResponseEntity<Refuelling> createRefuelling(@RequestBody Refuelling newRefuelling) {
        return new ResponseEntity<>(refuellingService.addRefueling(newRefuelling),HttpStatus.CREATED);
    }

    @PutMapping("/refuelling/update/{id}")
    public ResponseEntity<Refuelling> updateRefuelling(@RequestBody Refuelling updatedRefuelling,@PathVariable("id") int id) {
        Refuelling refuelling = refuellingService.updateRefuellingById(updatedRefuelling,id);

        if(refuelling == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(refuelling,HttpStatus.OK);


    }

    @DeleteMapping("/refuelling/delete/{id}")
    public ResponseEntity<Integer> deleteRefuelling(@PathVariable("id") int id) {
        Optional<Refuelling> refuelling = refuellingService.getOptionalRefuellingById(id);

        if(refuelling.isPresent()) {
            refuellingService.getRefuellingList().remove(refuelling.get());

            return new ResponseEntity<>(refuellingService.getRefuellingList().size(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
