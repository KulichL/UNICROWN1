/**
 * Příkaz umožňující hráči mluvit s postavou (NPC) v aktuální místnosti.
 * Hráč zadá jméno postavy a pokud se v místnosti nachází,
 * zobrazí se její promluva.
 *
 * @author Lukáš Kulich
 */
public class MluvCommand implements Command {

    /**
     * Vrátí název příkazu používaný ve hře.
     *
     * @return název příkazu
     */
    @Override
    public String name() { return "mluv"; }

    /**
     * Vrátí nápovědu k příkazu.
     *
     * @return text nápovědy
     */
    @Override
    public String help() { return "mluv <jmeno> – promluvíš s postavou"; }

    /**
     * Provede příkaz pro rozhovor s NPC postavou.
     *
     * @param game instance aktuální hry
     * @param args argumenty příkazu (jméno postavy)
     * @return výsledek příkazu obsahující text promluvy NPC
     */
    @Override
    public CommandResult execute(Game game, String[] args) {
        if (args.length < 1) return CommandResult.message("Použití: mluv <jmeno>");

        String token = args[0].toLowerCase();
        for (NPC npc : game.getCurrentRoom().getNpcs()) {
            if (npc.getName().toLowerCase().contains(token)) {
                return CommandResult.message(npc.speak());
            }
        }
        return CommandResult.message("Nikdo takovej tu není.");
    }
}