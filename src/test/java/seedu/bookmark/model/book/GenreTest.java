package seedu.bookmark.model.book;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.bookmark.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GenreTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Genre(null));
    }

    @Test
    public void constructor_invalidGenre_throwsIllegalArgumentException() {
        String invalidGenre = "";
        assertThrows(IllegalArgumentException.class, () -> new Genre(invalidGenre));
    }

    @Test
    public void constructor_tooLongGenre_throwsIllegalArgumentException() {
        StringBuilder tooLong = new StringBuilder();
        tooLong.append("a".repeat(Genre.MAX_GENRE_LENGTH + 2));
        assertThrows(IllegalArgumentException.class, () -> new Genre(tooLong.toString()));
    }

    @Test
    public void isValidGenre() {
        // null genre
        assertThrows(NullPointerException.class, () -> Genre.isValidGenre(null));

        // blank genre
        assertFalse(Genre.isValidGenre("")); // empty string
        assertFalse(Genre.isValidGenre(" ")); // spaces only

        // invalid genre
        assertFalse(Genre.isValidGenre("f1ct10nXDXD@@@@")); // mixture of alphanumeric and special characters

        StringBuilder tooLong = new StringBuilder();
        tooLong.append("a".repeat(Genre.MAX_GENRE_LENGTH + 2));
        assertFalse(Genre.isValidGenre(tooLong.toString())); // too long

        // valid genre
        assertTrue(Genre.isValidGenre("Horror 1")); // alphanumeric
        assertTrue(Genre.isValidGenre("Horror")); // First letter capitalized
        assertTrue(Genre.isValidGenre("horror")); // all lower caps
        assertTrue(Genre.isValidGenre("HORROR")); // all caps
        assertTrue(Genre.isValidGenre("non fiction")); // multiple words
    }
}
