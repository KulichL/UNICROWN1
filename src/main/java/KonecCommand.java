/**
 * Příkaz pro ukončení hry.
 * Po zadání tohoto příkazu se hra ukončí.
 *
 * @author Lukáš Kulich
 */
public class KonecCommand implements Command {
    /**
     * Vrátí název příkazu používaný ve hře.
     *
     * @return název příkazu
     */
    @Override public String name() { return "konec"; }
    /**
     * Vrátí nápovědu k příkazu.
     *
     * @return text nápovědy
     */
    @Override public String help() { return "konec – ukončí hru"; }
    /**
     * Provede příkaz pro ukončení hry.
     *
     * @param game instance aktuální hry
     * @param args argumenty příkazu (nepoužívají se)
     * @return výsledek příkazu s ukončením hry
     */
    @Override
    public CommandResult execute(Game game, String[] args) {
        return CommandResult.exit("Konec hry");
    }
}
