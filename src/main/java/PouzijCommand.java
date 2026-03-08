/**
 * Příkaz umožňující hráči použít předmět z inventáře.
 * Hráč zadá identifikátor nebo název předmětu,
 * který chce použít.
 *
 * @author Lukáš Kulich
 */
public class PouzijCommand implements Command {

    /**
     * Vrátí název příkazu používaný ve hře.
     *
     * @return název příkazu
     */
    @Override
    public String name() { return "pouzij"; }

    /**
     * Vrátí nápovědu k příkazu.
     *
     * @return text nápovědy
     */
    @Override
    public String help() { return "pouzij <id/nazev> – použije předmět z inventáře"; }

    /**
     * Provede příkaz pro použití předmětu z inventáře.
     *
     * @param game instance aktuální hry
     * @param args argumenty příkazu (id nebo název předmětu)
     * @return výsledek použití předmětu
     */
    @Override
    public CommandResult execute(Game game, String[] args) {
        if (args.length < 1) return CommandResult.message("Použití: pouzij <id/nazev>");

        Item item = game.getPlayer().getInventory().findByIdOrName(args[0]);
        if (item == null) return CommandResult.message("Takový předmět v inventáři nemáš.");

        return item.use(game);
    }
}