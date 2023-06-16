package fact.it.startproject.repository;

import fact.it.startproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findAllByNameContaining(String searchString);
}
