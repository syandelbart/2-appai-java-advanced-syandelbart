package fact.it.startproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(cascade={CascadeType.ALL})
    private Passport passport;

    @OneToMany(cascade={CascadeType.ALL})
    private List<Phone> phonenbrs = new ArrayList<>();

    @ManyToOne
    private Team team;

    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    public String toString() {
        return this.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Phone> getPhonenbrs() {
        return phonenbrs;
    }

    public void setPhonenbrs(List<Phone> phonenbrs) {
        this.phonenbrs = phonenbrs;
    }

    public void addPhonenbr(Phone phone) {
        this.phonenbrs.add(phone);
    }

    public void removePhonenbr(Phone phone) {
        this.phonenbrs.remove(phone);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


}
