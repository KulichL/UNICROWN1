/**
 * Tato třída spouští hru UNICROWN vytvořením instance
 * třídy Game a zavoláním její metody start().
 *
 * @author Lukáš Kulich
 */
public class Main {
    /**
     * Hlavní metoda programu, která spouští hru.
     *
     * @param args argumenty příkazové řádky
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

}