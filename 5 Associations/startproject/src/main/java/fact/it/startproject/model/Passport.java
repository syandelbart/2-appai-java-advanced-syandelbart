package fact.it.startproject.model;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String passportnbr;

    @OneToOne(mappedBy = "passport")
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassportnbr() {
        return passportnbr;
    }

    public void setPassportnbr(String passportnbr) {
        this.passportnbr = passportnbr;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
