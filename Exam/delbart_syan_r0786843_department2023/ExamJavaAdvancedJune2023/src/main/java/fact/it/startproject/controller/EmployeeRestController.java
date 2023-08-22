package fact.it.startproject.controller;

import fact.it.startproject.model.Department;
import fact.it.startproject.model.Employee;
import fact.it.startproject.repository.DepartmentRepository;
import fact.it.startproject.repository.EmployeeRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    EmployeeRepository employeeRepository;
    DepartmentRepository departmentRepository;


    public EmployeeRestController(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }


    @GetMapping("/employees/request")
    public List<String> getEmployeesNamePart(@RequestBody String namePart) {
        List<Employee> employeeList = this.employeeRepository.findAllByNameContaining(namePart);
        List<String> employeeString = employeeList.stream().map(employee -> {
            String string = employee.getEarningString();
            return string;
        }).toList();


        return employeeString;
    }

    @PostMapping("/employee")
    public String createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee.getEarningString();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Integer> deleteEmployee(@PathVariable long id) {
        Optional<Employee> employee1 = this.employeeRepository.findById(id);
        if (employee1.isPresent()) {
            Employee employee = employee1.get();

            //Check if is in department, did it with a stream since there is no reference to the departments from the employee side.
            Optional<Department> departmentFromEmployee = departmentRepository.findAll().stream().filter(department -> department.getEmployees().contains(employee)).findFirst();
            if(departmentFromEmployee.isPresent()) {
                return new ResponseEntity<>(this.employeeRepository.findAll().size(),HttpStatus.CONFLICT);
            }

            this.employeeRepository.delete(employee);
            return new ResponseEntity<>(this.employeeRepository.findAll().size(), HttpStatus.OK);
        }
        return new ResponseEntity<>(this.employeeRepository.findAll().size(), HttpStatus.NOT_FOUND);
    }
}
