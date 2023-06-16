package fact.it.startproject.model;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//Specify name of column which will show the different types, we could for example also use digits to track the differences
@DiscriminatorColumn(name="PERSONTYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Person")
@Entity
public class Person {

    //CAUTION, ID IS CHANGED
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    public Person() {

    }

    public String getClassName() {
        return this.getClass().getSimpleName();
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
}
