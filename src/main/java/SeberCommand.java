/**
 * Příkaz umožňující hráči sebrat předmět z aktuální místnosti
 * a přidat ho do inventáře.
 *
 * @author Lukáš Kulich
 */
public class SeberCommand implements Command {

    /**
     * Vrátí název příkazu používaný ve hře.
     *
     * @return název příkazu
     */
    @Override public String name() { return "seber"; }

    /**
     * Vrátí nápovědu k příkazu.
     *
     * @return text nápovědy
     */
    @Override public String help() { return "seber <id/nazev> – vezme předmět do inventáře"; }

    /**
     * Provede příkaz pro sebrání předmětu z místnosti.
     *
     * @param game instance aktuální hry
     * @param args argumenty příkazu (id nebo název předmětu)
     * @return výsledek provedení příkazu
     */
    @Override
    public CommandResult execute(Game game, String[] args) {
        if (args.length < 1) return CommandResult.message("Použití: seber <id/nazev>");

        String token = args[0].toLowerCase();
        Room room = game.getCurrentRoom();

        Item found = null;
        for (Item it : room.getItems()) {
            if (it.getId().equalsIgnoreCase(token) || it.getName().toLowerCase().contains(token)) {
                found = it;
                break;
            }
        }

        if (found == null) return CommandResult.message("Tady takovej předmět není.");

        boolean ok = game.getPlayer().getInventory().add(found);
        if (!ok) return CommandResult.message("Inventář je plný.");

        room.getItems().remove(found);
        return CommandResult.message("Sebral jsi: " + found.getName());
    }
}