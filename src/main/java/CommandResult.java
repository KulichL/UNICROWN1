/**
 * Třída reprezentující výsledek provedení příkazu ve hře.
 * Obsahuje textovou zprávu pro hráče a informaci,
 * zda má hra po vykonání příkazu skončit.
 *
 * @author Lukáš Kulich
 */
public class CommandResult {
    private final String message;
    private final boolean exit;

    /**
     * Vytvoří nový výsledek příkazu.
     *
     * @param message zpráva, která se zobrazí hráči
     * @param exit určuje, zda má hra skončit
     */
    public CommandResult(String message, boolean exit) {
        this.message = message;
        this.exit = exit;
    }


    /**
     * Vytvoří výsledek příkazu, který pouze zobrazí zprávu
     * a hra bude pokračovat.
     *
     * @param msg text zprávy
     * @return výsledek příkazu bez ukončení hry
     */
    public static CommandResult message(String msg) {
        return new CommandResult(msg, false);
    }


    /**
     * Vytvoří výsledek příkazu, který ukončí hru.
     *
     * @param msg text zprávy
     * @return výsledek příkazu s ukončením hry
     */
    public static CommandResult exit(String msg) {
        return new CommandResult(msg, true);
    }

    /**
     * Vrátí zprávu výsledku příkazu.
     *
     * @return text zprávy
     */
    public String getMessage() { return message; }
    /**
     * Určuje, zda má hra po vykonání příkazu skončit.
     *
     * @return true pokud má hra skončit
     */
    public boolean isExit() { return exit; }
}