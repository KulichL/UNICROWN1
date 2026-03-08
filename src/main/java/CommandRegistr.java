import java.util.*;

/**
 * Třída sloužící k registraci a správě všech příkazů ve hře.
 * Uchovává příkazy v mapě podle jejich názvu a umožňuje je vyhledávat.
 *
 * @author Lukáš Kulich
 */
public class CommandRegistr {
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Zaregistruje nový příkaz do registru.
     *
     * @param command příkaz, který se má zaregistrovat
     */
    public void register(Command command) {
        commands.put(command.name().toLowerCase(), command);
    }

    /**
     * Vrátí příkaz podle jeho názvu.
     *
     * @param name název příkazu
     * @return nalezený příkaz nebo null, pokud neexistuje
     */
    public Command get(String name) {
        return commands.get(name.toLowerCase());
    }

    /**
     * Vrátí kolekci všech zaregistrovaných příkazů.
     *
     * @return kolekce všech příkazů
     */
    public Collection<Command> all() {
        return commands.values();
    }
}
