package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RemarkTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Remark(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        String invalidAddress = "";
        assertThrows(IllegalArgumentException.class, () -> new Remark(invalidAddress));
    }

    @Test
    public void isValidAddress() {
        // null address
        assertThrows(NullPointerException.class, () -> Remark.isValidAddress(null));

        // invalid addresses
        assertFalse(Remark.isValidAddress("")); // empty string
        assertFalse(Remark.isValidAddress(" ")); // spaces only

        // valid addresses
        assertTrue(Remark.isValidAddress("Blk 456, Den Road, #01-355"));
        assertTrue(Remark.isValidAddress("-")); // one character
        assertTrue(Remark.isValidAddress("Leng Inc; 1234 Market St; San Francisco CA 2349879; USA")); // long address
    }
}
