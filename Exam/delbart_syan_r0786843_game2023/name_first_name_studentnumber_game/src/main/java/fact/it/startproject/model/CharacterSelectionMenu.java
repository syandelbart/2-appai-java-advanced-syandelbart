package fact.it.startproject.model;

// CharacterSelectionMenu class (Singleton)
public class CharacterSelectionMenu {
    private static CharacterSelectionMenu instance;

    // Private constructor to prevent direct instantiation
    private CharacterSelectionMenu() {
    }


    public static CharacterSelectionMenu getInstance() {
        if (instance == null) {
            synchronized (CharacterSelectionMenu.class) {
                if (instance == null) {
                    instance = new CharacterSelectionMenu();
                }
            }
        }
        return instance;
    }

    public Character createCharacter(String characterType, String name) {
        if (characterType.equalsIgnoreCase("warrior")) {
            return new Warrior(name);
        } else if (characterType.equalsIgnoreCase("mage")) {
            return new Mage(name);
        } else if (characterType.equalsIgnoreCase("archer")) {
            return new Archer(name);
        } else {
            throw new IllegalArgumentException("Invalid character type.");
        }
    }
}