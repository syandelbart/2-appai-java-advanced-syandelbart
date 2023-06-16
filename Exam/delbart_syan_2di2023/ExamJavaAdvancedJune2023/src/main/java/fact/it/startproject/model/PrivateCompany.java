package fact.it.startproject.model;


import javax.persistence.Entity;

@Entity
public class PrivateCompany extends Company {
    private String ownerName;


    public PrivateCompany() {

    }


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {

        this.ownerName = ownerName;

    }


}
