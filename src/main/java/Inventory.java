import java.util.*;
/**
 * Třída reprezentující inventář hráče.
 * Inventář uchovává předměty (Item), které hráč sebral během hry.
 * Má omezenou kapacitu a umožňuje přidávání, odebírání a vyhledávání předmětů.
 *
 * @author Lukáš Kulich
 */
public class Inventory {
    private final int capacity;
    private final List<Item> items = new ArrayList<>();


    /**
     * Vytvoří nový inventář s danou kapacitou.
     *
     * @param capacity maximální počet předmětů v inventáři
     */
    public Inventory(int capacity) {
        this.capacity = capacity;
    }
    /**
     * Přidá předmět do inventáře, pokud není plný.
     *
     * @param item předmět, který se má přidat
     * @return true pokud byl předmět přidán, jinak false
     */
    public boolean add(Item item) {
        if (items.size() >= capacity) return false;
        items.add(item);
        return true;
    }
    /**
     * Odebere předmět z inventáře.
     *
     * @param item předmět, který se má odebrat
     * @return true pokud byl předmět odebrán
     */
    public boolean remove(Item item) {
        return items.remove(item);
    }
    /**
     * Vyhledá předmět podle jeho ID nebo jména.
     *
     * @param token identifikátor nebo část jména předmětu
     * @return nalezený předmět nebo null pokud nebyl nalezen
     */
    public Item findByIdOrName(String token) {
        String t = token.toLowerCase();
        for (Item it : items) {
            if (it.getId().equalsIgnoreCase(token) || it.getName().toLowerCase().contains(t)) {
                return it;
            }
        }
        return null;
    }
    /**
     * Zjistí, zda je inventář prázdný.
     *
     * @return true pokud inventář neobsahuje žádné předměty
     */
    public boolean isEmpty() { return items.isEmpty(); }
    /**
     * Vrátí textovou reprezentaci inventáře.
     *
     * @return text se seznamem předmětů v inventáři
     */
    public String toText() {
        if (items.isEmpty()) return "Inventář je prázdný.";
        StringBuilder sb = new StringBuilder("Inventář:\n");
        for (Item it : items) {
            sb.append("- ").append(it.getName()).append(" (").append(it.getId()).append(")\n");
        }
        return sb.toString();
    }
}
