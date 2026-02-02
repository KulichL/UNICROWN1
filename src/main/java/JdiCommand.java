public class JdiCommand implements Command {

    @Override
    public String name() {
        return "jdi";
    }

    @Override
    public String help() {
        return "jdi <smer> – přesune tě do jiné místnosti";
    }

    @Override
    public CommandResult execute(Game game, String[] args) {
        if (args.length < 1) {
            return CommandResult.message("Použití: jdi <smer>");
        }

        String dir = args[0].toLowerCase();
        Room current = game.getCurrentRoom();

        String nextId = current.getExits().get(dir);
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
