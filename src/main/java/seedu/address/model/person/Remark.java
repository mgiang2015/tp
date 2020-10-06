package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Remark {

    public static final String MESSAGE_CONSTRAINTS = "Remark can take any values, and it can be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String remarkStr;

    /**
     * Constructs an {@code Remark}.
     *
     * @param remarkStr A valid address.
     */
    public Remark(String remarkStr) {
        requireNonNull(remarkStr);
        this.remarkStr = remarkStr;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return remarkStr;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && remarkStr.equals(((Remark) other).remarkStr)); // state check
    }

    @Override
    public int hashCode() {
        return remarkStr.hashCode();
    }

}
