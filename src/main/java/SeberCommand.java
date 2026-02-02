public class SeberCommand implements Command {
    @Override public String name() { return "seber"; }
    @Override public String help() { return "seber <id/nazev> – vezme předmět do inventáře"; }

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
