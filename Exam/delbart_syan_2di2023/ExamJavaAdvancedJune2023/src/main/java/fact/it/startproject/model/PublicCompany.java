package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class PublicCompany extends Company{
    private boolean federal;


    public boolean isFederal() {
        return federal;
    }

    public void setFederal(boolean federal) {
            this.federal = federal;
    }


}
