public class NapovedaCommand implements Command {
    private final CommandRegistr registry;

    public NapovedaCommand(CommandRegistr registry) {
        this.registry = registry;
    }

    @Override
    public String name() {
        return "napoveda";
    }

    @Override
    public String help() {
        return "napoveda – vypíše seznam příkazů";
    }

    @Override
    public CommandResult execute(Game game, String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Příkazy:\n");

        for (Command c : registry.all()) {
            sb.append("- ").append(c.name());
            if (c.help() != null && !c.help().isEmpty()) {
                sb.append(" : ").append(c.help());
            }
            sb.append("\n");
        }

        return CommandResult.message(sb.toString());
    }
}
