/**
 * Příkaz, který vypíše obsah inventáře hráče.
 * Hráč tímto příkazem zjistí, jaké předměty aktuálně nese.
 *
 * @author Lukáš Kulich
 */
public class InventarCommand implements Command {
    /**
     * Vrátí název příkazu používaný ve hře.
     *
     * @return název příkazu
     */
    @Override public String name() { return "inventar";}
    /**
     * Vrátí nápovědu k příkazu.
     *
     * @return text nápovědy
     */
    @Override public String help() { return "inventar – vypíše obsah inventáře"; }

    /**
     * Provede příkaz inventar a vypíše obsah inventáře hráče.
     *
     * @param game instance aktuální hry
     * @param args argumenty příkazu (nepoužívají se)
     * @return výsledek příkazu obsahující seznam předmětů
     */
    @Override
    public CommandResult execute(Game game, String[] args) {
        return CommandResult.message(game.getPlayer().getInventory().toText());
    }
}
