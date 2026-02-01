public class Enemy extends Character{
    private int strength;

    public Enemy(String name, int health, int strength) { super(name, health); }

    public void attack(Player player) {}

    public int getStrength() { return 0; }
}
