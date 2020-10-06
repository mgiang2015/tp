package seedu.address.logic.parser;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.RemarkCommand;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parse arguments given and return a new RemarkCommand object
 */
public class RemarkCommandParser implements Parser<Command> {

    public RemarkCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_REMARK);
        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemarkCommand.MESSAGE_USAGE), pe);
        }

        String remark = "empty remark";
        if (argMultimap.getValue(PREFIX_REMARK).isPresent()) {
            remark = argMultimap.getValue(PREFIX_REMARK).get();
        }

        return new RemarkCommand(index, remark);
    }
}
