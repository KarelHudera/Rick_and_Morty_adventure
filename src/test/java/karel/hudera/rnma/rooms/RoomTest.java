package karel.hudera.rnma.rooms;

import karel.hudera.rnma.characters.GameCharacter;
import karel.hudera.rnma.items.Item;
import karel.hudera.rnma.strings.StringResources;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Room room1;
    private Room room2;
    private Room room3;
    private Item item;
    private GameCharacter character;

    @BeforeEach
    void setUp() {
        room1 = new Room("Living Room", "A cozy living room.");
        room2 = new Room("Kitchen", "A kitchen with modern appliances.");
        room3 = new Room("Bathroom", "A small bathroom.");

        item = new Item("key", true);
        character = new GameCharacter("1", "John Doe", "Hello!");
    }

    @Test
    void testEquals() {
        assertEquals(room1, new Room("Living Room", "A cozy living room."), "Rooms with the same name and description should be equal.");
        assertNotEquals(room1, room2, "Rooms with different names should not be equal.");
        assertNotEquals(room1, null, "Room should not be equal to null.");
        assertNotEquals(room1, new Object(), "Room should not be equal to objects of other types.");
    }

    @Test
    void testHashCode() {
        assertEquals(room1.hashCode(), new Room("Living Room", "A cozy living room.").hashCode(), "Rooms with the same name and description should have the same hash code.");
        assertNotEquals(room1.hashCode(), room2.hashCode(), "Rooms with different names should have different hash codes.");
    }

    @Test
    void getName() {
        assertEquals("Living Room", room1.getName(), "The name of the room should be 'Living Room'.");
    }

    @Test
    void getEntranceByName() {
        room1.setEntrance(room2);
        assertEquals(room2, room1.getEntranceByName("Kitchen"), "The entrance with name 'Kitchen' should be returned.");
        assertNull(room1.getEntranceByName("Bathroom"), "Non-existent entrances should return null.");
    }

    @Test
    void getEntrances() {
        room1.setEntrance(room2);
        room1.setEntrance(room3);
        Set<Room> expectedEntrances = new HashSet<>();
        expectedEntrances.add(room2);
        expectedEntrances.add(room3);
        assertEquals(expectedEntrances, room1.getEntrances(), "The set of entrances should match the expected set.");
    }

    @Test
    void setEntrance() {
        room1.setEntrance(room2);
        assertTrue(room1.getEntrances().contains(room2), "The entrance should be added to the room.");
    }

    @Test
    void getDescription() {
        assertEquals("A cozy living room.", room1.getDescription(), "The description of the room should be 'A cozy living room.'.");
    }

    @Test
    void containsItem() {
        room1.addItem(item);
        assertTrue(room1.containsItem("key"), "Room should contain the item with name 'key'.");
        assertFalse(room1.containsItem("nonexistent"), "Room should not contain items with name 'nonexistent'.");
    }

    @Test
    void containsCharacter() {
        room1.addGameCharacter(character);
        assertTrue(room1.containsCharacter("John Doe"), "Room should contain the character with name 'John Doe'.");
        assertFalse(room1.containsCharacter("Jane Doe"), "Room should not contain characters with name 'Jane Doe'.");
    }

    @Test
    void getItem() {
        room1.addItem(item);
        assertEquals(item, room1.getItem("key"), "Room should return the item with name 'key'.");
        assertNull(room1.getItem("nonexistent"), "Room should return null for items that don't exist.");
    }

    @Test
    void getCharacter() {
        room1.addGameCharacter(character);
        assertEquals(character, room1.getCharacter("John Doe"), "Room should return the character with name 'John Doe'.");
        assertNull(room1.getCharacter("Jane Doe"), "Room should return null for characters that don't exist.");
    }

    @Test
    void addItem() {
        room1.addItem(item);
        assertTrue(room1.containsItem("key"), "The item should be added to the room.");
    }

    @Test
    void addGameCharacter() {
        room1.addGameCharacter(character);
        assertTrue(room1.containsCharacter("John Doe"), "The character should be added to the room.");
    }

    @Test
    void removeItem() {
        room1.addItem(item);
        assertNotNull(room1.removeItem("key"), "Removing an existing item should not return null.");
        assertNull(room1.removeItem("key"), "Removing a non-existent item should return null.");
    }

    @Test
    void detailedDescription() {
        room1.addItem(item);
        room1.addGameCharacter(character);
        room1.setEntrance(room2);

        String expectedDescription = String.format(
                "%s%s\n%s\n%s\n%s\n%s",
                StringResources.Info.YOU_ARE_IN,
                room1.getDescription(),
                "Entrances: Kitchen",
                "Items: key",
                "Characters: John Doe",
                StringResources.Info.DEAD_CHARACTERS + StringResources.Errors.NONE
        );
        assertEquals(expectedDescription, room1.detailedDescription(), "The detailed description should match the expected format.");
    }
}