package seedu.address.model.event;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_CALVIN;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import seedu.address.testutil.Assert;

public class AttendeesTest {

    private Set<String> attendeesSetOne;
    private Set<String> attendeesSetTwo;
    private Set<String> attendeesSetThree;

    @Before
    public void setup() {
        attendeesSetOne = new HashSet<>();
        attendeesSetTwo = new HashSet<>();
        attendeesSetThree = new HashSet<>();

        attendeesSetOne.add(VALID_NAME_AMY);
        attendeesSetTwo.add(VALID_NAME_BOB);
        attendeesSetThree.add(VALID_NAME_BOB);
        attendeesSetThree.add(VALID_NAME_CALVIN);
    }


    @Test
    public void constructor_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> new Attendees(null, attendeesSetOne));
    }

    @Test
    public void equals() {
        Attendees listOne = new Attendees(attendeesSetOne);
        Attendees listOneCopy = new Attendees(attendeesSetOne);
        Attendees listTwo = new Attendees(attendeesSetTwo);
        Attendees listThree = new Attendees(attendeesSetThree);

        // Attendees equal to itself
        assertTrue(listOne.equals(listOne));

        // Attendees equal to one with same content
        assertTrue(listOne.equals(listOneCopy));

        // Attendees not equal to one with different content
        assertFalse(listOne.equals(listTwo));
        assertFalse(listTwo.equals(listThree));
    }



}
