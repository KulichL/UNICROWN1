import java.util.Map;

/**
 * Třída reprezentující herní svět.
 * Uchovává všechny místnosti ve hře a identifikátor startovní místnosti.
 * Poskytuje metody pro získání místností a kontrolu správnosti mapy.
 *
 * @author Lukáš Kulich
 */
public class World {
    private Map<String, Room> rooms;
    private String startRoomId;

    /**
     * Vytvoří nový herní svět.
     *
     * @param rooms mapa všech místností ve hře (id → Room)
     * @param startRoomId identifikátor startovní místnosti
     */
    public World(Map<String, Room> rooms, String startRoomId) {
        this.rooms = rooms;
        this.startRoomId = startRoomId;
    }

    /**
     * Vrátí startovní místnost hry.
     *
     * @return startovní místnost
     */
    public Room getStartRoom() {
        return rooms.get(startRoomId);
    }

    /**
     * Vrátí místnost podle jejího identifikátoru.
     *
     * @param id identifikátor místnosti
     * @return nalezená místnost nebo null
     */
    public Room getRoomById(String id) {
        return rooms.get(id);
    }

    /**
     * Ověří správnost mapy světa.
     * Kontroluje, zda všechny východy z místností vedou
     * na existující místnosti.
     *
     * Pokud některý odkaz neexistuje, vyhodí výjimku.
     */
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