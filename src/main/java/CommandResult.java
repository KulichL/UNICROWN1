public class CommandResult {
    private final String message;
    private final boolean exit;

    public CommandResult(String message, boolean exit) {
        this.message = message;
        this.exit = exit;
    }

    public static CommandResult message(String msg) {
        return new CommandResult(msg, false);
    }

    public static CommandResult exit(String msg) {
        return new CommandResult(msg, true);
    }

    public String getMessage() { return message; }
    public boolean isExit() { return exit; }
}
