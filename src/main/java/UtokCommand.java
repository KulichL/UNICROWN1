/**
 * Příkaz umožňující hráči zaútočit na nepřítele v aktuální místnosti.
 * Hráč může zadat jméno nepřítele, na kterého chce zaútočit.
 *
 * @author Lukáš Kulich
 */
public class UtokCommand implements Command {

    /**
     * Vrátí název příkazu používaný ve hře.
     *
     * @return název příkazu
     */
    @Override public String name() { return "utok"; }

    /**
     * Vrátí nápovědu k příkazu.
     *
     * @return text nápovědy
     */
    @Override public String help() { return "utok <jmeno> – útok na nepřítele"; }

    /**
     * Provede příkaz útoku na nepřítele.
     * Samotná logika souboje je zpracována ve třídě Game.
     *
     * @param game instance aktuální hry
     * @param args argumenty příkazu (jméno nepřítele)
     * @return výsledek útoku
     */
    @Override
    public CommandResult execute(Game game, String[] args) {
        String target = (args.length > 0) ? args[0] : "";
        return game.attackEnemy(target);
    }
}