package dataStructureAlgorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {

    private Set set;

    @BeforeEach
    void setup() {
        set = new Set();
    }

    @Test
    public void newSetIsEmptyTest() {
        assertTrue(set.isEmpty());
    }

    @Test
    public void addX_newSetIsNotEmptyTest() {
        set.add("Mide");
        assertFalse(set.isEmpty());
    }

    @Test
    public void addX_removeX_setIsEmpty() {
        set.add("Mide");
        set.remove("Mide");
        assertTrue(set.isEmpty());
    }

    @Test
    public void addXY_removeX_setIsNotEmpty() {
        set.add("Mide");
        set.add("Tommy");

        set.remove("Mide");
        assertFalse(set.isEmpty());
    }

    @Test
    public void addX_addXAgain_returnsFalseTest() {
        set.add("Tosin");
        assertFalse(set.add("Tosin"));
    }

    @Test
    public void addXY_addXAgain_returnsFalse_sizeIs2Test() {
        set.add("Yemi");
        set.add("Tommy");
        assertFalse(set.add("Yemi"));
        assertEquals(2, set.size());
    }

    @Test
    public void addX_containsX_returnTrueTest() {
        set.add("Mide");
        assertTrue(set.contains("Mide"));
    }

    @Test
    public void addXY_addX_containsXReturnsFalseTest() {
        set.add("Yemi");
        set.add("Tommy");

        set.remove("Yemi");
        assertFalse(set.contains("Yemi"));
    }

    @Test
    public void addX_removeY_returnsFalseTest() {
        set.add("Yemi");
        assertFalse(set.remove("Tolu"));
    }
}