public class UtokCommand implements Command {
    @Override public String name() { return "utok"; }
    @Override public String help() { return "utok <jmeno> – útok na nepřítele"; }

    @Override
    public CommandResult execute(Game game, String[] args) {
        String target = (args.length > 0) ? args[0] : "";
        return game.attackEnemy(target);
    }
}
