public abstract class Command {
    protected String name;

    public Command(String name) {}

    public String getName() { return null; }

    public abstract CommandResult execute(Game game, String[] args);
}
