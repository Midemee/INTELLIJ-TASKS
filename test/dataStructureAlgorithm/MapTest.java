package dataStructureAlgorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {

    private Map map;

    @BeforeEach
    void setup() {
        map = new Map();
    }

    @Test
    public void newMapIsEmptyTest() {
        assertTrue(map.isEmpty());
    }

    @Test
    public void putKeyValue_mapIsNotEmptyTest() {
        map.push("Name", "Tosin");
        assertFalse(map.isEmpty());
    }

    @Test
    public void putKeyValue_removeKey_mapIsEmptyTest() {
        map.push("Name", "Yemi");
        map.remove("Name");
        assertTrue(map.isEmpty());
    }

    @Test
    public void putKey1Value1_putKey2Value2_removeKey1_mapIsNotEmptyTest() {
        map.push("Name", "Mide");
        map.push("Age", "32");
        map.remove("Name");
        assertFalse(map.isEmpty());
    }

    @Test
    public void putKey1Value1_getKey1_returnsValue1Test() {
        map.push("Name", "Mide");
        assertEquals("Mide", map.get("Name"));
    }

    @Test
    public void putKey1Value1_putKey2Value2_getKey2_returnsValue2Test() {
        map.push("Name", "Tayo");
        map.push("Age", "35");
        assertEquals("35", map.get("Age"));
    }

    @Test
    public void getInvalidKeyReturnsNullTest() {
        assertNull(map.get("Name"));
    }

    @Test
    public void putKeyValue_removeKey_returnsValueTest() {
        map.push("Name", "Tosin");
        assertEquals("Tosin", map.remove("Name"));
    }

    @Test
    public void putKey1Value1_putKey2Value2_removeKey2_returnsValue2Test() {
        map.push("Name", "Tosin");
        map.push("Age", "22");
        assertEquals("22", map.remove("Age"));
    }

    @Test
    public void putKey1Value1_putKey2Value2_removeKey2_sizeIs1Test() {
        map.push("Name", "Tolu");
        map.push("Age", "30");
        map.remove("Age");
        assertEquals(1, map.size());
    }
}
