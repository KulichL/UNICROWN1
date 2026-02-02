public class Enemy extends Character {
    private final int strength;

    public Enemy(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    public int attackDamage() {
        return strength;
    }

    @Override
    public String speak() {
        return "SUIII!";
    }
}
