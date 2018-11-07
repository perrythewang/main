package seedu.address.model.event;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//@@author: jieliangang
/**
 * Represents a the attendees with emails in a event.
 */
public class Attendees {
    private final Set<String> attendeesSet;

    public Attendees() {
        this.attendeesSet = new HashSet<>();
    }

    public Attendees(Set<String> attendeesSet) {
        Objects.requireNonNull(attendeesSet);
        this.attendeesSet = attendeesSet;
    }

    public Attendees(Set<String>... attendeesSet) {
        this();
        for (Set<String> emails: attendeesSet) {
            Objects.requireNonNull(emails);
            this.attendeesSet.addAll(emails);
        }
    }

    public Set<String> getAttendeesSet() {
        Set<String> attendeesSetCopy = attendeesSet;
        return attendeesSetCopy;
    }

    /**
     * Add email to attendees list
     * @param email The new email to be added.
     * @return A new copy of updated Attendees.
     */
    public Attendees createAttendeesWithAddedEmail(String email) {
        Set<String> updatedAttendees = new HashSet<>(this.attendeesSet);
        updatedAttendees.add(email);
        return new Attendees(updatedAttendees);
    }

    /**
     * Remove email from attendees list
     * @param email The email to be removed.
     * @return A new copy of updated Attendees.
     */
    public Attendees createAttendeesWithRemovedEmail(String email) {
        Set<String> updatedAttendees = new HashSet<>(this.attendeesSet);
        updatedAttendees.remove(email);
        return new Attendees(updatedAttendees);
    }

    /**
     * Returns whether set contains email.
     * @param email The email to be checked.
     */
    public boolean hasPerson(String email) {
        return attendeesSet.contains(email);
    }

    /**
     * Returns whether set is empty.
     */
    public boolean isSetEmpty() {
        return attendeesSet.isEmpty();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Attendees// instanceof handles nulls
                && attendeesSet.equals(((Attendees) other).attendeesSet)); // state check
    }

    @Override
    public int hashCode() {
        return attendeesSet.hashCode();
    }
}
