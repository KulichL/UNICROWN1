public class KonecCommand implements Command {
    @Override public String name() { return "konec"; }
    @Override public String help() { return "konec – ukončí hru"; }

    @Override
    public CommandResult execute(Game game, String[] args) {
        return CommandResult.exit("Konec hry");
    }
}
