package fact.it.startproject.repository;

import fact.it.startproject.model.Bread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreadRepository extends JpaRepository<Bread,Long> {
    List<Bread> findAllByNameStartsWith(String searchString);
    List<Bread> findAllByOrderByPriceAsc();

    @Query("select b from Bread b order by b.price asc")
    List<Bread> giveListOfAllBreadsOrderedByPrice();


    @Query("select b from Bread b where b.price in (select min(b.price) from Bread b)")
    List <Bread> findCheapest();
}
