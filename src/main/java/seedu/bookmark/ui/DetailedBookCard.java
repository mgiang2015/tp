package seedu.bookmark.ui;

import java.util.List;
import java.util.stream.IntStream;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import seedu.bookmark.model.book.Book;
import seedu.bookmark.model.book.Goal;
import seedu.bookmark.model.book.Note;

/**
 * An UI component that displays more detailed information of a {@code Book}.
 */
public class DetailedBookCard extends BookCard {

    private static final String COMPLETED_STYLE = "-fx-text-fill: lime";
    private static final String DEFAULT_STYLE = "";
    private static final String FXML = "DetailedBookCard.fxml";
    private static final String IN_PROGRESS_STYLE = "-fx-text-fill: gold";
    private static final String OVERDUE_STYLE = "-fx-text-fill: red";


    @FXML
    private Label percentageCompletion;

    @FXML
    private Label goal;

    @FXML
    private VBox notesContainer;

    @FXML
    private Label noteHeading;

    /**
     * Creates a {@code DetailedBookCard} with the given {@code Book} and index to display.
     */
    public DetailedBookCard(Book book, int displayedIndex) {
        super(book, FXML);
        initialize(book, displayedIndex);
    }

    @Override
    protected void initialize(Book book, int displayedIndex) {
        super.initialize(book, displayedIndex);
        int percentageCompleted = calculateCompletion(book);
        String progressDisplay = "Progress: " + String.valueOf(percentageCompleted) + "%";
        String goalText = "Goal: " + book.getGoal().toString();
        goalText = determineGoalText(book, goalText);
        percentageCompletion.setText(progressDisplay);
        goal.setText(goalText);
        goal.setStyle(determineGoalStyle(book));
        showNotes(book.getNotes());
    }

    private int calculateCompletion(Book book) {
        float pagesRead = book.getPagesRead();
        float totalPages = book.getTotalPagesNumber();
        return (int) ((pagesRead / totalPages) * 100);
    }

    private String determineGoalStyle(Book book) {
        if (book.goalCompleted()) {
            return COMPLETED_STYLE;
        } else if (book.goalInProgress()) {
            return IN_PROGRESS_STYLE;
        } else if (book.goalOverdue()) {
            return OVERDUE_STYLE;
        } else { // No goal
            return DEFAULT_STYLE;
        }
    }

    private String determineGoalText(Book book, String goalTextOriginal) {
        String goalText = goalTextOriginal;
        if (book.goalCompleted()) {
            goalText += Goal.UI_COMPLETED;
        } else if (book.goalOverdue()) {
            goalText += Goal.UI_OVERDUE;
        } else if (book.goalInProgress()) {
            goalText += Goal.UI_IN_PROGRESS;
        }
        return goalText;
    }

    private void showNotes(List<Note> notes) {
        if (notes.size() > 0) {
            noteHeading.setText("Notes:");
        } else {
            noteHeading.setText("Notes: This book has no notes!");
        }
        IntStream.rangeClosed(1, notes.size())
                .mapToObj(i -> new NoteCard(notes.get(i - 1), i))
                .forEach(note -> notesContainer
                        .getChildren()
                        .add(note.getRoot()));
    }
}
