import java.util.*;

public class Game {
    private World world;
    private Room currentRoom;
    private Player player;

    private final Scanner scanner = new Scanner(System.in);
    private final CommandRegistr registry = new CommandRegistr();

    private boolean running = true;
    private boolean defending = false;

    public void start() {
        initWorld();
        initPlayer();
        initCommands();
        printWelcome();
        printCurrentRoom();
        initActors();
        runLoop();
        registry.register(new ObranaCommand());

        System.out.println("Konec.");
    }

    private void initActors() {
        Room forest = world.getRoomById("forest");
        Room cave = world.getRoomById("cave");
        Room gate = world.getRoomById("gate");
        Room kitchen = world.getRoomById("kitchen");
        Room throne = world.getRoomById("throne");
        Room library = world.getRoomById("library");


        if (forest != null) forest.getNpcs().add(new NPC("Gorlock", 999, "Jsem Gorlock. Jdu s tebou!"));
        if (cave != null) cave.getNpcs().add(new NPC("Cicilda", 999, "Slabina krále je kouzelný prášek z knihovny!"));
        if (gate != null) gate.getEnemies().add(new Enemy("Strážce", 30, 8));
        if (kitchen != null) kitchen.getEnemies().add(new Enemy("Kuchař", 35, 10));
        if (throne != null) throne.getEnemies().add(new Enemy("Král Cicibuk", 80, 15));

        if (library != null) library.getItems().add(new MagicPowder());
    }

    private boolean kingWeakened = false;

    public void weakenKing() {
        this.kingWeakened = true;
    }

    public boolean isKingWeakened() {
        return kingWeakened;
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
        registry.register(new ObranaCommand());
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
        System.out.println("Vítej v UNICROWNU!");
        System.out.println("Napiš 'napoveda' pro seznam příkazů.\n");
    }

    public CommandResult attackEnemy(String token) {
        Room room = getCurrentRoom();

        if (room.getEnemies().isEmpty()) {
            return CommandResult.message("V této místnosti není žádný nepřítel.");
        }

        Enemy enemy;
        if (token == null || token.isEmpty()) {
            enemy = room.getEnemies().get(0);
        } else {
            enemy = room.findEnemy(token);
            if (enemy == null) return CommandResult.message("Takový nepřítel tu není.");
        }

        boolean isKing = enemy.getName().toLowerCase().contains("cicibuk");

        int playerDmg = 10;

        StringBuilder sb = new StringBuilder();

        if (isKing && !kingWeakened) {
            sb.append("Král Cicibuk se jen směje… Bez kouzelného prášku mu neublížíš!\n");
        } else {
            enemy.takeDamage(playerDmg);
            sb.append("Zaútočil jsi na ").append(enemy.getName())
                    .append(" a udělil jsi ").append(playerDmg).append(" dmg.\n");

            if (!enemy.isAlive()) {
                room.getEnemies().remove(enemy);
                sb.append(enemy.getName()).append(" byl poražen!\n");


                if (isKing) {
                    return CommandResult.exit("Porazil jsi krále Cicibuka! Vítězství!");
                }

                return CommandResult.message(sb.toString());
            }
        }

        int enemyDmg = enemy.attackDamage();
        if (defending) {
            enemyDmg = Math.max(1, enemyDmg / 2);
            sb.append("Bránil ses, poškození je sníženo.\n");
        }

        getPlayer().takeDamage(enemyDmg);
        defending = false;

        sb.append(enemy.getName()).append(" ti dal ").append(enemyDmg).append(" dmg.\n")
                .append("Tvoje životy: ").append(getPlayer().getHealth()).append("\n");

        if (!getPlayer().isAlive()) {
            return CommandResult.exit("Byl jsi poražen. Konec hry.");
        }

        return CommandResult.message(sb.toString());
    }

    public void setDefending(boolean defending) {
        this.defending = defending;
    }

        public void printCurrentRoom() {
        System.out.println(currentRoom.getName());
        System.out.println(currentRoom.getDescription());

        if (!currentRoom.getItems().isEmpty()) {
            System.out.println("Předměty: " + currentRoom.itemsToString());
        }
        if (!currentRoom.getEnemies().isEmpty()) {
            System.out.println("Nepřátelé: " + currentRoom.enemiesToString());
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
