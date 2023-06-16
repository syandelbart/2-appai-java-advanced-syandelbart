package fact.it.startproject;

import fact.it.startproject.model.*;
import fact.it.startproject.model.Character;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class startprojectApplicationTests {
//
    @Test
    public void a_testSingleton() {
        CharacterSelectionMenu csMenu = CharacterSelectionMenu.getInstance();
        CharacterSelectionMenu csMenu2 = CharacterSelectionMenu.getInstance();
        assertTrue(csMenu == csMenu2);
    }

    @Test
    public void testDefaultStrategy_Mage() {
        Mage mage = new Mage("Mage");
        assertEquals("a fireball",mage.getAttackStrategy().attack());
    }

    @Test
    public void testDefaultStrategy_Archer() {
        Archer archer = new Archer("Archer");
        assertEquals("a bow",archer.getAttackStrategy().attack());
    }

    @Test
    public void testDefaultStrategy_Warrior() {
        Warrior warrior = new Warrior("Warrior");
        assertEquals("a sword",warrior.getAttackStrategy().attack());
    }

    @Test
    public void testChangedStrategy_Mage() {
        Mage mage = new Mage("Mage");
        mage.setAttackStrategy(new BowAttack());
        assertEquals("a bow",mage.getAttackStrategy().attack());
    }

    @Test
    public void testChangedStrategy_Archer() {
        Archer archer = new Archer("Archer");
        archer.setAttackStrategy(new SwordAttack());
        assertEquals("a sword",archer.getAttackStrategy().attack());
    }

    @Test
    public void testChangedStrategy_Warrior() {
        Warrior warrior = new Warrior("Warrior");
        warrior.setAttackStrategy(new FireballAttack());
        assertEquals("a fireball",warrior.getAttackStrategy().attack());
    }


//
//
}




