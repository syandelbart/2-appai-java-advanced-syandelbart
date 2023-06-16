package fact.it.startproject.model;

// Warrior class
public class Warrior extends Character{
    public Warrior(String name) {
        this.setName(name);
        this.setAttackStrategy(new SwordAttack());
    }

}