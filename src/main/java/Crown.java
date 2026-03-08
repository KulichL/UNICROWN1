/**
 * Třída reprezentující královskou korunu ve hře.
 * Koruna je speciální předmět, který po použití
 * ukončí hru a znamená vítězství hráče.
 *
 * @author Lukáš Kulich
 */
public class Crown extends Item {
    /**
     * Vytvoří novou královskou korunu.
     *
     * @param id identifikátor předmětu
     */
    public Crown(String id) {
        super(id, "Koruna");
    }

    /**
     * Použije královskou korunu.
     * Po jejím použití hráč vyhrává hru.
     *
     * @param game instance aktuální hry
     * @return výsledek příkazu s ukončením hry
     */
    @Override
    public CommandResult use(Game game) {
        return CommandResult.exit("Nasadil jsi si královskou korunu. VYHRÁL JSI HRU!");
    }
}
