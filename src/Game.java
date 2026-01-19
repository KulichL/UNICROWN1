import java.util.Scanner;

public class Game {
    private Player player;
    private Location currentLocation;
    private int state;

    private CommandRegistr registry;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
        registry = new CommandRegistr();
        state = GameState.RUNNING;
    }

    public void start() {
        initCommands();
        initWorld();

        while (state == GameState.RUNNING) {
            System.out.print("> ");
            String input = scanner.nextLine();
            processInput(input);
        }
    }

    private void processInput(String input) {
        String[] parts = input.split(" ");
        String commandName = parts[0];

        String[] args = new String[parts.length - 1];
        for (int i = 1; i < parts.length; i++) {
            args[i - 1] = parts[i];
        }

        Command command = registry.get(commandName);

        if (command == null) {
            System.out.println("Neznámý příkaz.");
            return;
        }

        CommandResult result = command.execute(this, args);
        System.out.println(result.getMessage());
    }

    private void initCommands() {}
    private void initWorld() {}

    public Player getPlayer() { return player; }
    public Location getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(Location loc) { currentLocation = loc; }

    public void setState(int state) { this.state = state; }
}
