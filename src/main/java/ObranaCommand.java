/**
 * Příkaz, který umožňuje hráči bránit se.
 * Při použití tohoto příkazu bude příští útok nepřítele slabší.
 *
 * @author Lukáš Kulich
 */
public class ObranaCommand implements Command {

    /**
     * Vrátí název příkazu používaný ve hře.
     *
     * @return název příkazu
     */
    @Override
    public String name() { return "obrana"; }

    /**
     * Vrátí nápovědu k příkazu.
     *
     * @return text nápovědy
     */
    @Override
    public String help() { return "obrana – Příští kolo je nepřítel oslaben."; }

    /**
     * Aktivuje obranu hráče, která sníží poškození
     * při příštím útoku nepřítele.
     *
     * @param game instance aktuální hry
     * @param args argumenty příkazu (nepoužívají se)
     * @return výsledek provedení příkazu
     */
    @Override
    public CommandResult execute(Game game, String[] args) {
        game.setDefending(true);
        return CommandResult.message("Jsi v obraně. Další útok bude slabší.");
    }
}