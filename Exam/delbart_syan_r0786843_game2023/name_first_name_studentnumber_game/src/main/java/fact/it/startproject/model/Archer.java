package fact.it.startproject.model;

// Archer class
public class Archer extends Character{
    public Archer(String name) {
        this.setName(name);
        this.setAttackStrategy(new BowAttack());
    }



}