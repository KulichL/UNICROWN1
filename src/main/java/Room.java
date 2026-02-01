import java.util.Map;

public class Room {
    private String id;
    private String name;
    private String description;
    private Map<String, String> exits;

    public Room(String id, String name, String description, Map<String, String> exits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.exits = exits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasExit(String direction) {
        return exits.containsKey(direction);
    }

    public String getExitTargetId(String direction) {
        return exits.get(direction);
    }

    public Map<String, String> getExits() {
        return exits;
    }
}
