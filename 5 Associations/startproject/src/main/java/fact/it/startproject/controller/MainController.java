package fact.it.startproject.controller;

import fact.it.startproject.model.Passport;
import fact.it.startproject.model.Person;
import fact.it.startproject.model.Phone;
import fact.it.startproject.model.Team;
import fact.it.startproject.repository.PersonRepository;
import fact.it.startproject.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    PersonRepository personRepository;
    TeamRepository teamRepository;

    public MainController(PersonRepository personRepository, TeamRepository teamRepository) {
        this.personRepository = personRepository;
        this.teamRepository = teamRepository;
    }


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/addTeam")
    public String addTeam() {
        return "addTeam";
    }

    @RequestMapping("/submitTeam")
    public String submitTeam(Model model, HttpServletRequest request) {
        String assignment = request.getParameter("assignment");
        String number = request.getParameter("number");

        Team team = new Team();
        team.setAssignment(assignment);
        team.setNumber(number);

        teamRepository.save(team);
        List<Team> teams = teamRepository.findAll();
        model.addAttribute("teams",teams);

        return "index";
    }

    @RequestMapping("/addPerson")
    public String addPerson(Model model) {
        model.addAttribute("teams",teamRepository.findAll());
        return "addPerson";
    }

    @RequestMapping("/submitPerson")
    public String submitPerson(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String passportNumber = request.getParameter("passportNumber");
        Long teamId = Long.parseLong(request.getParameter("teamId"));

        Person person = new Person();
        person.setName(name);

        Passport passport = new Passport();
        passport.setPassportnbr(passportNumber);

        person.setPassport(passport);

        Optional<Team> team = teamRepository.findById(teamId);

        if(team.isPresent()) {
            person.setTeam(team.get());
        }

        personRepository.save(person);
        List<Team> teams = teamRepository.findAll();
        model.addAttribute("teams",teams);

        return "index";
    }

    @RequestMapping("/addPhone")
    public String addPhone(Model model,HttpServletRequest request) {

        model.addAttribute("persons",personRepository.findAll());

        return "addPhone";
    }

    @RequestMapping("/submitPhone")
    public String submitPhone(Model model, HttpServletRequest request) {
        String type = request.getParameter("type");
        String number = request.getParameter("number");
        Long personId = Long.parseLong(request.getParameter("personId"));

        Phone phone = new Phone();
        phone.setType(type);
        phone.setNumber(number);

        Optional<Person> person = personRepository.findById(personId);

        if(person.isPresent()) {
            Person personParsed = person.get();
            personParsed.addPhonenbr(phone);
            personRepository.save(personParsed);
        }

        List<Team> teams = teamRepository.findAll();
        model.addAttribute("teams",teams);

        return "index";
    }


}
