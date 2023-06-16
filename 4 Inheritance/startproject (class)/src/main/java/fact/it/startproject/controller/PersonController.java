package fact.it.startproject.controller;

import fact.it.startproject.model.Customer;
import fact.it.startproject.model.Employee;
import fact.it.startproject.model.Executive;
import fact.it.startproject.model.Person;
import fact.it.startproject.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PersonController {
    PersonRepository personRepository;

    PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Person> list = this.personRepository.findAll();
        model.addAttribute("personlist", list);

        return "index";
    }

    @RequestMapping("/addPerson")
    public String addPerson() {
        return "addPerson";
    }

    @RequestMapping("/submitPerson")
    public String submitPerson(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");

        Person newPerson = new Person();
        newPerson.setName(name);
        this.personRepository.save(newPerson);

        model.addAttribute("personlist",this.personRepository.findAll());

        return "index";
    }

    @RequestMapping("/addCustomer")
    public String addCustomer() {
        return "addCustomer";
    }

    @RequestMapping("/submitCustomer")
    public String submitCustomer(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        double discount = Double.parseDouble(request.getParameter("discount"));

        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setDiscount(discount);
        this.personRepository.save(newCustomer);

        model.addAttribute("personlist",this.personRepository.findAll());

        return "index";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee() {
        return "addEmployee";
    }

    @RequestMapping("/submitEmployee")
    public String submitEmployee(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee newEmployee = new Employee();
        newEmployee.setName(name);
        newEmployee.setSalary(salary);
        this.personRepository.save(newEmployee);

        model.addAttribute("personlist",this.personRepository.findAll());

        return "index";
    }

    @RequestMapping("/addExecutive")
    public String addExecutive() {
        return "addExecutive";
    }

    @RequestMapping("/submitExecutive")
    public String submitExecutive(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        double salary = Double.parseDouble(request.getParameter("salary"));

        double bonus = Double.parseDouble(request.getParameter("bonus"));


        Executive newExecutive = new Executive();
        newExecutive.setName(name);
        newExecutive.setSalary(salary);
        newExecutive.setBonus(bonus);
        this.personRepository.save(newExecutive);

        model.addAttribute("personlist",this.personRepository.findAll());

        return "index";
    }
}
