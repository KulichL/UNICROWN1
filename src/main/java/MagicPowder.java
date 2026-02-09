public class MagicPowder extends Item {

    public MagicPowder() {
        super("prasek", "Kouzelný prášek");
    }

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