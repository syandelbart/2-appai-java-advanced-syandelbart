package fact.it.startproject.model;

// Character class
public abstract class Character {

    private String name;

    private AttackStrategy attackStrategy;

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String start() {
        return this.getClass().getSimpleName() + " " + this.name + " is ready to attack with " + this.attackStrategy.attack();
    }

}