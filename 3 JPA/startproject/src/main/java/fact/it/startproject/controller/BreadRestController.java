package fact.it.startproject.controller;

import fact.it.startproject.model.Bread;
import fact.it.startproject.repository.BreadRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BreadRestController {
    private BreadRepository breadRepository;

    public BreadRestController(BreadRepository breadRepository) {
        this.breadRepository = breadRepository;
    }

    @GetMapping("/breads")
    public List<Bread> getBreads() {
        return breadRepository.giveListOfAllBreadsOrderedByPrice();
    }

    // a service to query all bread records from the database
    // where the name starts with a certain letter combination
    @GetMapping("/breads/search")
    public List<Bread> getBreadsNamePart(@RequestBody String namePart) {
        return breadRepository.findAllByNameStartsWith(namePart);
    }

    @GetMapping("/breads/{id}")
    public Bread getBreadById(@PathVariable("id") Long id) {
        return breadRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Bread with id " + id + " does not exist.")
        );
    }

    //a service to find the cheapest bread
    @GetMapping("/breads/searchcheapest")
    public List<Bread> getBreadsCheapest() {
        return breadRepository.findCheapest();
    }

    //a service to add a bread record in the database. This service also returns the added bread object
    @PostMapping("/breads")
    public Bread createBread(@RequestBody Bread bread) {
        return breadRepository.save(bread);
    }

    //a service to modify a bread record in the database. This service returns the modified bread-object if found, if not, it returns HTTP 40
    @PutMapping("/breads/{id}")
    public ResponseEntity<Bread> changeBread(@RequestBody Bread updateBread, @PathVariable long id) {
        Optional<Bread> bread1 = breadRepository.findById(id);
        if (bread1.isPresent()) {
            Bread bread = bread1.get();
            bread.setName(updateBread.getName());
            bread.setPrice(updateBread.getPrice());
            breadRepository.save(bread);
            return new ResponseEntity<>(bread, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/breads/{id}")
    public ResponseEntity<Integer> deleteBread(@PathVariable long id) {
        Optional<Bread> bread1 = breadRepository.findById(id);
        if (bread1.isPresent()) {
            Bread bread = bread1.get();
            breadRepository.delete(bread);
            return new ResponseEntity<>(breadRepository.findAll().size(), HttpStatus.OK);
        }
        return new ResponseEntity<>(breadRepository.findAll().size(), HttpStatus.NOT_FOUND);
    }
}