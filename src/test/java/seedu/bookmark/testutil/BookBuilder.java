package seedu.bookmark.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.bookmark.model.book.Bookmark;
import seedu.bookmark.model.book.Genre;
import seedu.bookmark.model.book.Name;
import seedu.bookmark.model.book.Book;
import seedu.bookmark.model.book.TotalPages;
import seedu.bookmark.model.tag.Tag;
import seedu.bookmark.model.util.SampleDataUtil;

/**
 * A utility class to help with building Book objects.
 */
public class BookBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_GENRE = "Fiction";
    public static final String DEFAULT_TOTAL_PAGES = "1000";

    private Name name;
    private Genre genre;
    private Set<Tag> tags;
    private TotalPages totalPages;
    private Bookmark bookmark;

    /**
     * Creates a {@code BookBuilder} with the default details.
     */
    public BookBuilder() {
        name = new Name(DEFAULT_NAME);
        genre = new Genre(DEFAULT_GENRE);
        totalPages = new TotalPages(DEFAULT_TOTAL_PAGES);
        tags = new HashSet<>();
    }

    /**
     * Initializes the BookBuilder with the data of {@code bookToCopy}.
     */
    public BookBuilder(Book bookToCopy) {
        name = bookToCopy.getName();
        genre = bookToCopy.getGenre();
        totalPages = bookToCopy.getTotalPages();
        bookmark = bookToCopy.getBookmark().orElse(null);
        tags = new HashSet<>(bookToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Book} that we are building.
     */
    public BookBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Book} that we are building.
     */
    public BookBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Genre} of the {@code Book} that we are building.
     */
    public BookBuilder withGenre(String genre) {
        this.genre = new Genre(genre);
        return this;
    }

    /**
     * Sets the {@code TotalPages} of the {@code Book} that we are building.
     */
    public BookBuilder withTotalPages(String totalPages) {
        this.totalPages = new TotalPages(totalPages);
        return this;
    }

    /**
     * Sets the {@code Bookmark} of the {@code Book} that we are building.
     */
    public BookBuilder withBookmark(String bookmark) {
        this.bookmark = new Bookmark(bookmark, this.totalPages);
        return this;
    }

    public Book build() {
        return new Book(name, genre, tags, totalPages, bookmark);
    }

}
