public class Crown extends Item {
    public Crown(String id) {
        super(id, "Koruna");
    }

    @Override
    public CommandResult use(Game game) {
        return CommandResult.message("Nemůžeš použít krounu jen tak");
    }
}
