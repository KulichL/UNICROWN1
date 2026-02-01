public class Player {
    private String name;
    private int health;
    private Inventory inventory;

    public Player(String name, int health, int inventoryCapacity) {}

    public void talk(NPC npc) {}

    public void attack(Enemy enemy) {}

    public void useItem(Item item) {}

    public Inventory getInventory() { return null; }

    public String getName() { return null; }

    public int getHealth() { return 0; }

    public void setHealth(int health) {}
}
