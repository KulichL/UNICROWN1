/**
 * Třída reprezentující nehráčskou postavu (NPC) ve hře.
 * NPC může hráči poskytnout nápovědu nebo informaci
 * prostřednictvím dialogu.
 *
 * @author Lukáš Kulich
 */
public class NPC extends Character {
    private final String hint;

    /**
     * Vytvoří novou NPC postavu.
     *
     * @param name jméno postavy
     * @param health počet životů postavy
     * @param hint text, který postava říká hráči
     */
    public NPC(String name, int health, String hint) {
        super(name, health);
        this.hint = hint;
    }

    /**
     * Vrátí text, který NPC říká hráči.
     *
     * @return text promluvy NPC
     */
    @Override
    public String speak() {
        return hint;
    }
}