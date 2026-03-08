/**
 * Třída reprezentující hráče ve hře.
 * Hráč má jméno, životy a vlastní inventář,
 * do kterého může ukládat předměty.
 *
 * @author Lukáš Kulich
 */
public class Player extends Character {
    private final Inventory inventory;

    /**
     * Vytvoří nového hráče.
     *
     * @param name jméno hráče
     * @param health počáteční počet životů hráče
     * @param inventory inventář hráče
     */
    public Player(String name, int health, Inventory inventory) {
        super(name, health);
        this.inventory = inventory;
    }

    /**
     * Vrátí inventář hráče.
     *
     * @return inventář hráče
     */
    public Inventory getInventory() { return inventory; }

    /**
     * Vrátí text, který hráč říká.
     *
     * @return text promluvy hráče
     */
    @Override
    public String speak() {
        return "Jdu na to!";
    }
}