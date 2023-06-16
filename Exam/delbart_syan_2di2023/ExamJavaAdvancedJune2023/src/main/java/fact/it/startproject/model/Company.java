package fact.it.startproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String location;


    @OneToMany(mappedBy = "company")
    private List<Department> departmentList;

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public String getCompanyClass() {
        return this.getClass().getSimpleName();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
