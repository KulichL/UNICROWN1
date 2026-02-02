public interface Command {
    String name();
    String help();
    CommandResult execute(Game game, String[] args);
}
