import java.util.*;

public class CommandRegistr {
    private final Map<String, Command> commands = new HashMap<>();

    public void register(Command command) {
        commands.put(command.name().toLowerCase(), command);
    }

    public Command get(String name) {
        return commands.get(name.toLowerCase());
    }

    public Collection<Command> all() {
        return commands.values();
    }
}
