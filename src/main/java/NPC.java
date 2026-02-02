public class NPC extends Character {
    private final String hint;

    public NPC(String name, int health, String hint) {
        super(name, health);
        this.hint = hint;
    }

    @Override
    public String speak() {
        return hint;
    }
}
