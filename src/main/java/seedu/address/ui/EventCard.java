package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.event.Event;


/**
 * An UI component that displays information of a {@code Person}.
 */
public class EventCard extends UiPart<Region> {

    private static final String FXML = "EventListCard.fxml";
    private static final String[] TAG_COLOR = {"red", "orange", "yellow", "green", "blue", "indigo", "purple", "pink"};

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Event event;

    @FXML
    private HBox eventCardPane;
    @FXML
    private Label eventName;
    @FXML
    private Label eventId;
    @FXML
    private Label description;
    @FXML
    private Label eventLocation;
    @FXML
    private Label eventDate;
    @FXML
    private Label startTime;
    @FXML
    private Label endTime;

    public EventCard(Event event, int displayedIndex) {
        super(FXML);
        this.event = event;
        eventId.setText(displayedIndex + ". ");
        eventName.setText(event.getEventName().fullName);
        description.setText(event.getDescription().value);
        eventLocation.setText(String.format(event.getLocation().value));
        eventDate.setText(String.format(event.getDate().eventDate));
        startTime.setText(String.format(event.getStartTime().time));
        endTime.setText(String.format(event.getEndTime().time));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EventCard)) {
            return false;
        }

        // state check
        EventCard card = (EventCard) other;
        return eventId.getText().equals(card.eventId.getText())
                && event.equals(card.event);
    }

}
