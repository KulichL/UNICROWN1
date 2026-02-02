import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JsonWorldLoader {

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
