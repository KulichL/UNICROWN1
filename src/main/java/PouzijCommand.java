public class PouzijCommand implements Command {
    @Override public String name() { return "pouzij"; }
    @Override public String help() { return "pouzij <id/nazev> – použije předmět z inventáře"; }

    @Override
    public CommandResult execute(Game game, String[] args) {
        if (args.length < 1) return CommandResult.message("Použití: pouzij <id/nazev>");

        Item item = game.getPlayer().getInventory().findByIdOrName(args[0]);
        if (item == null) return CommandResult.message("Takový předmět v inventáři nemáš.");

        return item.use(game);
    }
}
