public class MluvCommand implements Command {
    @Override public String name() { return "mluv"; }
    @Override public String help() { return "mluv <jmeno> – promluvíš s postavou"; }

    @Override
    public CommandResult execute(Game game, String[] args) {
        if (args.length < 1) return CommandResult.message("Použití: mluv <jmeno>");

        String token = args[0].toLowerCase();
        for (NPC npc : game.getCurrentRoom().getNpcs()) {
            if (npc.getName().toLowerCase().contains(token)) {
                return CommandResult.message(npc.speak());
            }
        }
        return CommandResult.message("Nikdo takovej tu není.");
    }
}
