public abstract class Item {
    protected final String id;
    protected final String name;

    protected Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public abstract CommandResult use(Game game);
}
