import java.util.*;

public class Game {
    private World world;
    private Room currentRoom;
    private Player player;

    private final Scanner scanner = new Scanner(System.in);
    private final CommandRegistr registry = new CommandRegistr();

    private boolean running = true;

    public void start() {
        initWorld();
        initPlayer();
        initCommands();

        printWelcome();
        printCurrentRoom();

        runLoop();

        System.out.println("Konec.");
    }

    private void runLoop() {
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            CommandResult result = handleInput(input);

            if (result != null && result.getMessage() != null && !result.getMessage().isEmpty()) {
                System.out.println(result.getMessage());
            }

            if (result != null && result.isExit()) {
                running = false;
            }
        }
    }

    public CommandResult handleInput(String input) {
        String[] parts = input.split("\\s+");
        String cmdName = parts[0].toLowerCase();
        String[] args = Arrays.copyOfRange(parts, 1, parts.length);

        Command cmd = registry.get(cmdName);
        if (cmd == null) {
            return CommandResult.message("Neznámý příkaz. Napiš 'napoveda'.");
        }
        return cmd.execute(this, args);
    }

    private void initCommands() {
        registry.register(new NapovedaCommand(registry));
        registry.register(new JdiCommand());
        registry.register(new SeberCommand());
        registry.register(new InventarCommand());
        registry.register(new PouzijCommand());
        registry.register(new MluvCommand());
        registry.register(new UtokCommand());
        registry.register(new KonecCommand());
    }

    private void initWorld() {
        JsonWorldLoader loader = new JsonWorldLoader();
        this.world = loader.loadWorld("world.json");
        this.currentRoom = world.getStartRoom();
        if (this.currentRoom == null) {
            throw new RuntimeException("Startovní místnost je null. Zkontroluj startRoomId ve world.json.");
        }
    }

    private void initPlayer() {
        this.player = new Player("Mufflin", 100, new Inventory(5));
    }

    private void printWelcome() {
        System.out.println("Vítej ve hře UNICROWN!");
        System.out.println("Napiš 'napoveda' pro seznam příkazů.\n");
    }

    public void printCurrentRoom() {
        System.out.println(currentRoom.getName());
        System.out.println(currentRoom.getDescription());

        if (!currentRoom.getItems().isEmpty()) {
            System.out.println("Předměty: " + currentRoom.itemsToString());
        }
        if (!currentRoom.getNpcs().isEmpty()) {
            System.out.println("Postavy: " + currentRoom.npcsToString());
        }
        System.out.println("Východy: " + currentRoom.exitsToString());
    }

    public World getWorld() {
        return world;
    }


    public Room getCurrentRoom() { return currentRoom; }
    public void setCurrentRoom(Room room) { this.currentRoom = room; }
    public Player getPlayer() { return player; }
    public void stop() { this.running = false; }
}
