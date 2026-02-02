public class UtokCommand implements Command {
    @Override public String name() { return "utok"; }
    @Override public String help() { return "utok <jmeno> – útok na nepřítele"; }

    @Override
    public CommandResult execute(Game game, String[] args) {
        return CommandResult.message("Nemáš na koho útočit.");
    }
}
