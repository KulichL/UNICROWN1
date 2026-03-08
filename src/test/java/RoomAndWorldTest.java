import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RoomAndWorldTest {

    @Test
    void findEnemy_shouldReturnMatchingEnemy() {
        Map<String, String> exits = new HashMap<>();
        Room room = new Room("gate", "Brána", "Vstup do hradu", exits);
        Enemy enemy = new Enemy("Král Cicibuk", 80, 15);
        room.getEnemies().add(enemy);

        Enemy found = room.findEnemy("cicibuk");

        assertNotNull(found);
        assertEquals("Král Cicibuk", found.getName());
    }

    @Test
    void validate_shouldThrowExceptionWhenExitLeadsToMissingRoom() {
        Map<String, String> exits = new HashMap<>();
        exits.put("sever", "neexistuje");

        Room start = new Room("start", "Start", "Začátek hry", exits);

        Map<String, Room> rooms = new HashMap<>();
        rooms.put("start", start);

        World world = new World(rooms, "start");

        assertThrows(RuntimeException.class, world::validate);
    }
}
