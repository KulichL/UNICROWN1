public class Player extends Character {
    private final Inventory inventory;

    public Player(String name, int health, Inventory inventory) {
        super(name, health);
        this.inventory = inventory;
    }

    public Inventory getInventory() { return inventory; }

    @Override
    public String speak() {
        return "Jdu na to!";
    }
}

