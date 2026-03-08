/**
 * Příkaz umožňující hráči přesun mezi místnostmi.
 * Hráč zadá směr a pokud v aktuální místnosti nejsou nepřátelé,
 * přesune se do sousední místnosti.
 *
 * @author Lukáš Kulich
 */
public class JdiCommand implements Command {

    /**
     * Vrátí název příkazu používaný ve hře.
     *
     * @return název příkazu
     */
    @Override
    public String name() {
        return "jdi";
    }

    /**
     * Vrátí nápovědu k příkazu.
     *
     * @return text nápovědy
     */
    @Override
    public String help() {
        return "jdi <smer> – přesune tě do jiné místnosti";
    }

    /**
     * Provede příkaz pro přesun do jiné místnosti.
     * Pokud jsou v místnosti nepřátelé, hráč nemůže odejít.
     *
     * @param game instance aktuální hry
     * @param args argumenty příkazu (směr pohybu)
     * @return výsledek provedení příkazu
     */
    @Override
    public CommandResult execute(Game game, String[] args) {
        if (args.length < 1) {
            return CommandResult.message("Použití: jdi <smer>");
        }

        Room current = game.getCurrentRoom();

        if (!current.getEnemies().isEmpty()) {
            return CommandResult.message(
                    "Nemůžeš odejít, dokud neporazíš všechny nepřátele v místnosti!"
            );
        }

        String dir = args[0].toLowerCase();
        String nextId = (String) current.getExits().get(dir);

        if (nextId == null) {
            return CommandResult.message("Tímto směrem jít nemůžeš.");
        }

        Room next = game.getWorld().getRoomById(nextId);
        if (next == null) {
            return CommandResult.message("Chyba mapy: místnost '" + nextId + "' neexistuje.");
        }

        game.setCurrentRoom(next);
        game.printCurrentRoom();
        return CommandResult.message("");
    }
}