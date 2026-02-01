import java.util.Scanner;

public class Game {

    private World world;
    private Room currentRoom;

    private int state;

    private final Scanner scanner;
    private final CommandRegistr registry;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.registry = new CommandRegistr();
        this.state = GameState.RUNNING;
    }


    public void start() {
        initWorld();
        initCommands();

        System.out.println("Vítej ve hře UNICROWN!");
        System.out.println("Napiš 'napoveda' pro seznam příkazů.\n");

        printCurrentRoom();

        while (state == GameState.RUNNING) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            CommandResult result = processInput(input);

            if (result != null && result.getMessage() != null && !result.getMessage().isEmpty()) {
                System.out.println(result.getMessage());
            }
        }

        System.out.println("Konec.");
    }

    private void initWorld() {
        JsonWorldLoader loader = new JsonWorldLoader();
        this.world = loader.loadWorld("world.json");
        this.currentRoom = world.getStartRoom();

        if (this.currentRoom == null) {
            throw new RuntimeException("Startovní místnost je null. Zkontroluj startRoomId v world.json.");
        }
    }



    private void initCommands() {
        registry.register(new JdiCommand());
        registry.register(new KonecCommand());
        registry.register(new NapovedaCommand());
    }


    public CommandResult processInput(String input) {
        String[] parts = input.split("\\s+");
        String commandName = parts[0].toLowerCase();

        String[] args = new String[Math.max(0, parts.length - 1)];
        for (int i = 1; i < parts.length; i++) {
            args[i - 1] = parts[i].toLowerCase();
        }

        Command cmd = registry.get(commandName);
        if (cmd == null) {
            return new CommandResult(false, "Neznámý příkaz. Napiš 'napoveda'.");
        }

        return cmd.execute(this, args);
    }

    public CommandResult move(String direction) {
        if (direction == null || direction.isEmpty()) {
            return new CommandResult(false, "Musíš zadat směr. Např.: jdi east");
        }

        if (!currentRoom.hasExit(direction)) {
            return new CommandResult(false, "Tímto směrem se nedá jít. Zůstáváš v: " + currentRoom.getName());
        }

        String nextId = currentRoom.getExitTargetId(direction);
        Room nextRoom = world.getRoomById(nextId);

        if (nextRoom == null) {
            return new CommandResult(false, "Chyba světa: místnost '" + nextId + "' neexistuje.");
        }

        currentRoom = nextRoom;
        return new CommandResult(true, buildRoomInfo());
    }


    public void printCurrentRoom() {
        System.out.println(buildRoomInfo());
    }

    private String buildRoomInfo() {
        String exits = currentRoom.getExits().keySet().toString();
        return "\n" +
                currentRoom.getName() + "\n" +
                currentRoom.getDescription() + "\n" +
                "Východy: " + exits + "\n";
    }


    public World getWorld() {
        return world;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public CommandRegistr getRegistr() {
        return registry;
    }
}