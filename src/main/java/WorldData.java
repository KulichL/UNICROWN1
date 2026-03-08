import java.util.List;

/**
 * Datová třída používaná pro načítání herního světa ze souboru JSON.
 * Obsahuje identifikátor startovní místnosti a seznam dat jednotlivých místností.
 *
 * Tato třída slouží jako pomocná struktura pro deserializaci
 * JSON dat pomocí knihovny Gson.
 *
 * @author Lukáš Kulich
 */
public class WorldData {

    /**
     * Identifikátor startovní místnosti ve hře.
     */
    public String startRoomId;

    /**
     * Seznam dat všech místností ve světě.
     */
    public List<RoomData> rooms;
}