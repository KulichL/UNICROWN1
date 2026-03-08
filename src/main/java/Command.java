/**
 * Rozhraní reprezentující příkaz ve hře.
 * Každý příkaz musí mít název, nápovědu a metodu pro vykonání.
 * Implementace tohoto rozhraní definují konkrétní chování příkazů.
 *
 * @author Lukáš Kulich
 */
public interface Command {
    /**
     * Vrátí název příkazu, který hráč zadává do hry.
     *
     * @return název příkazu
     */
    String name();

    /**
     * Vrátí nápovědu k příkazu, která vysvětluje jeho použití.
     *
     * @return text nápovědy
     */
    String help();
    /**
     * Provede příkaz ve hře.
     *
     * @param game instance hry, ve které se příkaz provádí
     * @param args argumenty příkazu zadané hráčem
     * @return výsledek provedení příkazu
     */
    CommandResult execute(Game game, String[] args);
}
