/**
 * Abstraktní třída reprezentující předmět ve hře.
 * Každý předmět má unikátní identifikátor a název
 * a může být použit hráčem.
 *
 * Konkrétní chování při použití předmětu je definováno
 * v potomcích této třídy.
 *
 * @author Lukáš Kulich
 */
public abstract class Item {
    protected final String id;
    protected final String name;

    /**
     * Vytvoří nový předmět se zadaným identifikátorem a názvem.
     *
     * @param id unikátní identifikátor předmětu
     * @param name název předmětu
     */
    protected Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Vrátí identifikátor předmětu.
     *
     * @return identifikátor předmětu
     */
    public String getId() { return id; }
    /**
     * Vrátí název předmětu.
     *
     * @return název předmětu
     */
    public String getName() { return name; }
    /**
     * Použije předmět ve hře.
     * Konkrétní implementace je definována v potomcích.
     *
     * @param game instance aktuální hry
     * @return výsledek použití předmětu
     */
    public abstract CommandResult use(Game game);
}
