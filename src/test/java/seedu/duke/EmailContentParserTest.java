package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import static seedu.duke.email.EmailContentParser.editDistance;

public class EmailContentParserTest {
    @Test
    public void editDistanceTest() {
        assertEquals(1, editDistance("a", "b"));
        assertEquals(1, editDistance("a", ""));
        assertEquals(2, editDistance("a", "bc"));
        assertEquals(1, editDistance("a", "ba"));
        assertEquals(4, editDistance("food", "money"));
    }
}
