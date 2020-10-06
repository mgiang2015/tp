package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Changes the remarks of a person in the list.
 */
public class RemarkCommand extends Command {

    public static final String COMMAND_WORD = "remark";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult("Hello from remark command :D");
    }
}
