package dataStructureAlgorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArraylistsTest {
   private Arraylists lists;

    @BeforeEach
    public void setUp(){
        lists = new Arraylists(10);
    }
    @Test
    public void testThatArrayListsIsEmpty(){
        assertTrue(lists.isEmpty());
    }

    @Test
    public void testThatIHaveArrayListsAndAddAnElementArrayListsIsNotEmpty(){
        lists.add("Tosin");
        assertFalse(lists.isEmpty());
    }

    @Test
    public void testThatIHaveArrayListsIAddedAnElementToAFixedIndexItReturnsTheElementRemoved(){
        lists.add("Tosin");
        lists.add("Mide");
        lists.add("Tonye");
        lists.add("Yemi");
        assertEquals("Mide", lists.remove(1));
    }

    @Test
    public void testThatIHaveArrayLists_IAddItemToAFixedIndexItReturnsTheElementAdded(){
        lists.add("Tosin");
        lists.add("Mide");
        lists.add("Tonye");
        lists.add("Yemi");
        lists.addElement(1, "Tobi");
        assertEquals("Tobi", lists.get(1));
    }

    @Test
    public void testThatIHaveArrayLists_IGetElementAtTheLastIndex(){
        lists.add("Tosin");
        lists.add("Mide");
        lists.add("Tonye");
        lists.add("Yemi");
        assertEquals("Yemi", lists.getLast());
    }

    @Test
    public void testThatIHaveArrayLists_IGetElementAtTheFirstIndex(){
        lists.add("Tosin");
        lists.add("Mide");
        lists.add("Tonye");
        lists.add("Yemi");
        assertEquals("Tosin", lists.getFirst());
    }
    @Test
    public void testThatIHaveArrayLists_IAddElementToTheFirstIndex(){
        lists.add("Tosin");
        lists.add("Mide");
        lists.add("Tonye");
        lists.addFirst("Yemi");
        assertEquals("Yemi", lists.getFirst());
    }
}
