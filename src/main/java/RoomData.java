import java.util.Map;

/**
 * Datová třída sloužící pro načtení informací o místnosti z JSON souboru.
 * Obsahuje základní údaje potřebné pro vytvoření instance třídy Room.
 *
 * Používá se při deserializaci JSON dat pomocí knihovny Gson.
 *
 * @author Lukáš Kulich
 */
public class RoomData {

    /**
     * Unikátní identifikátor místnosti.
     */
    public String id;

    /**
     * Název místnosti.
     */
    public String name;

    /**
     * Textový popis místnosti.
     */
    public String description;

    /**
     * Mapa východů z místnosti (směr → id cílové místnosti).
     */
    public Map<String, String> exits;
}