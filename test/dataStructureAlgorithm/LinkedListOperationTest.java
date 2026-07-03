package dataStructureAlgorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListOperationTest {

    private LinkedListOperation list;

    @BeforeEach
    void setUp() {
        list = new LinkedListOperation(7);
    }

    @Test
    public void testThatNewLinkedListIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testThatAfterIAddOneElementLinkedListIsNotEmpty() {
        list.addLast("Aramide");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testThatICanAddElementToTheEndOfList() {
        list.addLast("Aramide");
        list.addLast("Bolu");

        assertEquals("Aramide", list.getFirst());
        assertEquals("Bolu", list.getLast());
    }

    @Test
    public void testThatICanAddElementToTheFrontOfList() {
        list.addFirst("Aramide");
        list.addFirst("Bolu");

        assertEquals("Bolu", list.getFirst());
        assertEquals("Aramide", list.getLast());
    }

    @Test
    public void testThatICanDeleteFromFrontOfList() {
        list.addLast("Aramide");
        list.addLast("Bolu");
        list.addLast("Tosin");

        list.deleteFirst();
        assertEquals("Bolu", list.getFirst());
    }

    @Test
    public void testThatICanDeleteFromEndOfList() {
        list.addLast("Aramide");
        list.addLast("Bolu");
        list.addLast("Tosin");

        list.deleteLast();
        assertEquals("Bolu", list.getLast());
    }

    @Test
    public void testThatDeletingFromEmptyListThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> list.deleteFirst());
    }

    @Test
    public void testThatICanCheckIfListContainsElement() {
        list.addLast("Aramide");
        list.addLast("Bolu");

        assertTrue(list.contains("Aramide"));
        assertFalse(list.contains("Tosin"));
    }

    @Test
    public void testThatICanGetSizeOfList() {
        list.addLast("Aramide");
        list.addLast("Bolu");
        list.addLast("Tosin");

        assertEquals(3, list.size());
    }

    @Test
    public void testThatICanConvertListToArray() {
        list.addLast("Aramide");
        list.addLast("Bolu");
        list.addLast("Tosin");

        assertArrayEquals(new String[]{"Aramide", "Bolu", "Tosin"}, list.toArray());
    }

    @Test
    public void testThatAddingMoreThanCapacityThrowsException() {
        LinkedListOperation list = new LinkedListOperation(3);

        list.addLast("Aramide");
        list.addLast("Bolu");
        list.addLast("Tosin");

        assertThrows(IllegalArgumentException.class, () -> list.addLast("Mercy"));
    }

    @Test
    public void testThatAddingToFrontMoreThanCapacityThrowsException() {
        LinkedListOperation list = new LinkedListOperation(3);

        list.addFirst("Aramide");
        list.addFirst("Bolu");
        list.addFirst("Tosin");

        assertThrows(IllegalArgumentException.class, () -> list.addFirst("Mercy"));
    }
}
