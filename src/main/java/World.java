import java.util.Map;

public class World {
    private Map<String, Room> rooms;
    private String startRoomId;

    public World(Map<String, Room> rooms, String startRoomId) {
        this.rooms = rooms;
        this.startRoomId = startRoomId;
    }

    public Room getStartRoom() {
        return rooms.get(startRoomId);
    }

    public Room getRoomById(String id) {
        return rooms.get(id);
    }

    public void validate() {
        for (Room room : rooms.values()) {
            for (String targetId : room.getExits().values()) {
                if (!rooms.containsKey(targetId)) {
                    throw new RuntimeException(
                            "Místnost '" + room.getId() + "' odkazuje na neexistující místnost '" + targetId + "'");
                }
            }
        }
    }
}
