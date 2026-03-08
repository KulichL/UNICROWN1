import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Třída zodpovědná za načtení herního světa ze souboru JSON.
 * Pomocí knihovny Gson převede data ze souboru na objekty Room
 * a vytvoří instanci třídy World.
 *
 * @author Lukáš Kulich
 */
public class JsonWorldLoader {

    /**
     * Načte herní svět ze zadaného JSON souboru.
     *
     * @param resourcePath cesta k JSON souboru v resources
     * @return vytvořený herní svět
     */
    public World loadWorld(String resourcePath) {
        Gson gson = new Gson();

        System.out.println("Hledám resource: [" + resourcePath + "]");
        System.out.println("ClassLoader: " + JsonWorldLoader.class.getClassLoader());

        InputStream stream = JsonWorldLoader.class.getClassLoader().getResourceAsStream(resourcePath);
        if (stream == null) {
            throw new RuntimeException("Soubor " + resourcePath + " nebyl nalezen.");
        }

        WorldData data = gson.fromJson(new InputStreamReader(stream), WorldData.class);

        Map<String, Room> rooms = new HashMap<>();
        for (RoomData rd : data.rooms) {
            Room room = new Room(rd.id, rd.name, rd.description, rd.exits);
            rooms.put(rd.id, room);
        }

        World world = new World(rooms, data.startRoomId);
        world.validate();

        return world;
    }
}