public class MagicPowder extends Item {
    public MagicPowder(String id) {
        super(id, "Kouzelný prášek");
    }

    @Override
    public CommandResult use(Game game) {
        return CommandResult.message("Použil jsi kouzelný prášek. To je materiál,co?");
    }
}
