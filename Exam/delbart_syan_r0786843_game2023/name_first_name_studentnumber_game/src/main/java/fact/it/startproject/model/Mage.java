package fact.it.startproject.model;

// Mage class
public class Mage extends Character {
    public Mage(String name) {
        this.setName(name);
        this.setAttackStrategy(new FireballAttack());

    }


}