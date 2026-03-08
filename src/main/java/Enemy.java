/**
 * Třída reprezentující nepřítele ve hře.
 * Nepřítel má určitou sílu útoku a může bojovat s hráčem.
 * Tato třída dědí základní vlastnosti postavy z třídy Character.
 *
 * @author Lukáš Kulich
 */
public class Enemy extends Character {
    private final int strength;


    /**
     * Vytvoří nového nepřítele.
     *
     * @param name jméno nepřítele
     * @param health počáteční počet životů nepřítele
     * @param strength síla útoku nepřítele
     */
    public Enemy(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    /**
     * Vrátí hodnotu poškození, které nepřítel způsobí při útoku.
     *
     * @return síla útoku nepřítele
     */
    public int attackDamage() {
        return strength;
    }

    /**
     * Vrátí aktuální počet životů nepřítele.
     *
     * @return počet životů
     */
    @Override
    public int getHealth() {
        return health;
    }

    /**
     * Odečte nepříteli životy podle přijatého poškození.
     * Životy nikdy neklesnou pod 0.
     *
     * @param damage množství poškození
     */
    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    /**
     * Vrátí text, který nepřítel říká.
     *
     * @return text promluvy nepřítele
     */
    @Override
    public String speak() {
        return "SUIII!";
    }

    /**
     * Zjistí, zda je nepřítel stále naživu.
     *
     * @return true pokud má nepřítel více než 0 životů
     */
    public boolean isAlive() {
        return health > 0;
    }
}
