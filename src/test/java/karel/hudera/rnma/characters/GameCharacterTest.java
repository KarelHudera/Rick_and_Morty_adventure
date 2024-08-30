package karel.hudera.rnma.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameCharacterTest {

    private GameCharacter character;

    @BeforeEach
    void setUp() {
        // Initialize the GameCharacter instance before each test
        character = new GameCharacter("1", "rick", "Wubba lubba dub dub!");
    }

    @Test
    void speak() {
        // Test the speak method
        assertEquals("Rick: Wubba lubba dub dub!", character.speak(), "The character's speech should be correctly formatted.");
    }

    @Test
    void isAlive() {
        // Test the isAlive method when the character is newly created
        assertTrue(character.isAlive(), "The character should be alive initially.");
    }

    @Test
    void setDead() {
        // Test the setDead method
        character.setDead();
        assertFalse(character.isAlive(), "The character should be dead after calling setDead.");
    }

    @Test
    void getName() {
        // Test the getName method
        assertEquals("rick", character.getName(), "The character's name should be 'rick'.");
    }

    @Test
    void getID() {
        // Test the getID method
        assertEquals("1", character.getID(), "The character's ID should be '1'.");
    }

    @Test
    void capitalizeFirstLetter() {
        // Test the capitalizeFirstLetter method using reflection, as it's package-private
        try {
            var method = GameCharacter.class.getDeclaredMethod("capitalizeFirstLetter", String.class);
            method.setAccessible(true);
            String result = (String) method.invoke(character, "hello");
            assertEquals("Hello", result, "The capitalized string should be 'Hello'.");
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    void setSpeakString() {
        // Test the setSpeakString method
        character.setSpeakString("New speech");
        assertEquals("Rick: New speech", character.speak(), "The character's speech should be updated to 'New speech'.");
    }
}