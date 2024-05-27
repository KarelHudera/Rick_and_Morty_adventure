package karel.hudera.rnma.rooms;

import karel.hudera.rnma.characters.GameCharacter;
import karel.hudera.rnma.objects.GameObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Room {
    private String name;
    private String description;
    private Set<Room> entrances;
    private Map<String, GameObject> objects = new HashMap<>();
    private Map<String, GameCharacter> characters = new HashMap<>();


}