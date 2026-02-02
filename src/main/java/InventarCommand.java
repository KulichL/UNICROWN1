public class InventarCommand implements Command {
    @Override public String name() { return "inventar"; }
    @Override public String help() { return "inventar – vypíše obsah inventáře"; }

    @Override
    public CommandResult execute(Game game, String[] args) {
        return CommandResult.message(game.getPlayer().getInventory().toText());
    }
}
