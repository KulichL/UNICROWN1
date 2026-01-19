import java.util.List;
import java.util.Map;


public class Location {
    private String name;
    private String description;

    // například: "portal" -> Location(portal)
    private Map<String, Location> exits;

    private List<NPC> npcs;
    private List<Item> items;

    public Location(String name, String description) {}

    public void enter(Game game) {}

    public String getName() { return null; }

    public String getDescription() { return null; }

    public Map<String, Location> getExits() { return null; }

    public Location getExit(String keyword) { return null; }

    public void addExit(String keyword, Location target) {}

    public List<NPC> getNpcs() { return null; }

    public NPC findNpc(String name) { return null; }

    public void addNpc(NPC npc) {}

    public List<Item> getItems() { return null; }

    public Item findItem(String name) { return null; }

    public void addItem(Item item) {}

    public boolean removeItem(Item item) { return false; }
}
