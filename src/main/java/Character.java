public abstract class Character {
    protected String name;
    protected int health;

    protected Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }

    public boolean isAlive() { return health > 0; }

    public void takeDamage(int dmg) {
        health = Math.max(0, health - dmg);
    }

    public abstract String speak();
}

