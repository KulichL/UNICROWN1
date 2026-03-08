/**
 * Abstraktní třída reprezentující postavu ve hře.
 * Postava má jméno a určitý počet životů.
 * Tato třída slouží jako rodičovská třída pro hráče,
 * nepřátele nebo NPC.
 *
 * @author Lukáš Kulich
 */
public abstract class Character {
    protected String name;
    protected int health;

    /**
     * Vytvoří novou postavu se jménem a počtem životů.
     *
     * @param name jméno postavy
     * @param health počáteční počet životů
     */
    protected Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    /**
     * Vrátí jméno postavy.
     *
     * @return jméno postavy
     */
    public String getName() { return name; }
    /**
     * Vrátí aktuální počet životů postavy.
     *
     * @return počet životů
     */
    public int getHealth() { return health; }

    /**
     * Zjistí, zda je postava stále naživu.
     *
     * @return true pokud má postava více než 0 životů
     */
    public boolean isAlive() { return health > 0; }

    /**
     * Odečte postavě životy podle způsobeného poškození.
     * Životy nikdy neklesnou pod 0.
     *
     * @param dmg množství poškození
     */
    public void takeDamage(int dmg) {
        health = Math.max(0, health - dmg);
    }

    /**
     * Vrátí text, který postava říká.
     * Konkrétní implementace je definována v potomcích.
     *
     * @return text promluvy
     */
    public abstract String speak();
}

