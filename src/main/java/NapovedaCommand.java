/**
 * Příkaz, který vypíše seznam všech dostupných příkazů ve hře.
 * Informace o příkazech získává z registru příkazů.
 *
 * @author Lukáš Kulich
 */
public class NapovedaCommand implements Command {
    private final CommandRegistr registry;

    /**
     * Vytvoří nový příkaz nápovědy.
     *
     * @param registry registr obsahující všechny dostupné příkazy
     */
    public NapovedaCommand(CommandRegistr registry) {
        this.registry = registry;
    }

    /**
     * Vrátí název příkazu používaný ve hře.
     *
     * @return název příkazu
     */
    @Override
    public String name() {
        return "napoveda";
    }

    /**
     * Vrátí nápovědu k příkazu.
     *
     * @return text nápovědy
     */
    @Override
    public String help() {
        return "napoveda – vypíše seznam příkazů";
    }

    /**
     * Provede příkaz nápovědy a vypíše seznam všech příkazů.
     *
     * @param game instance aktuální hry
     * @param args argumenty příkazu (nepoužívají se)
     * @return výsledek příkazu obsahující seznam příkazů
     */
    @Override
    public CommandResult execute(Game game, String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Příkazy:\n");

        for (Command c : registry.all()) {
            sb.append("- ").append(c.name());
            if (c.help() != null && !c.help().isEmpty()) {
                sb.append(" : ").append(c.help());
            }
            sb.append("\n");
        }

        return CommandResult.message(sb.toString());
    }
}