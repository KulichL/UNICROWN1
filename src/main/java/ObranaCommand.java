public class ObranaCommand implements Command {
    @Override public String name() { return "obrana"; }
    @Override public String help() { return "obrana – Příští kolo je nepřítel oslaben."; }

    @Override
    public CommandResult execute(Game game, String[] args) {
        game.setDefending(true);
        return CommandResult.message("Jsi v obraně. Další útok bude slabší.");
    }
}