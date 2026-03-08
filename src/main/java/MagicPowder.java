/**
 * Třída reprezentující kouzelný prášek ve hře.
 * Tento předmět slouží k oslabení krále Cicibuka
 * v trůnním sále, aby ho bylo možné porazit.
 *
 * @author Lukáš Kulich
 */
public class MagicPowder extends Item {
    /**
     * Vytvoří nový kouzelný prášek.
     */
    public MagicPowder() {
        super("prasek", "Kouzelný prášek");
    }
    /**
     * Použije kouzelný prášek.
     * Prášek lze použít pouze v trůnním sále u krále.
     * Po použití je král oslaben a prášek se odebere z inventáře.
     *
     * @param game instance aktuální hry
     * @return výsledek použití předmětu
     */
    @Override
    public CommandResult use(Game game) {

        if (!game.getCurrentRoom().getId().equals("throne")) {
            return CommandResult.message("Prášek má smysl použít až u krále v trůnním sále.");
        }

        if (game.isKingWeakened()) {
            return CommandResult.message("Král už je oslabený. Prášek už nepotřebuješ.");
        }

        game.weakenKing();

        Item me = game.getPlayer().getInventory().findByIdOrName("prasek");
        if (me != null) {
            game.getPlayer().getInventory().remove(me);
        }

        return CommandResult.message("Použil jsi kouzelný prášek! Král Cicibuk je oslaben.");
    }
}