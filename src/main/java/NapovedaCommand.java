public class NapovedaCommand extends Command{
    public NapovedaCommand() {
        super("napoveda");
    }

    @Override
    public CommandResult execute(Game game, String[] args) {
        return new CommandResult(true,
                "Příkazy:\n" +
                        "- jdi <north|south|east|west>\n" +
                        "- napoveda\n" +
                        "- konec"
        );
    }
}
