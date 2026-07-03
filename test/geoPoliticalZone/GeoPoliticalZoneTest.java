package geoPoliticalZone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GeoPoliticalZoneTest {
    @Test
    public void checkUserState_ReturnGeoPoliticalZoneTest(){
        assertEquals(GeoPoliticalZone.NORTH_CENTRAL, GeoPoliticalZone.findZone("Benue"));
    }

    @Test
    public void checkUserStateIgnoreCase_IfSameWithGeoPoliticalZoneTest(){
        assertSame(GeoPoliticalZone.NORTH_EAST, GeoPoliticalZone.findZone("TARABA"));
    }

    @Test
    public void checkInvalidUserState_ReturnsNullTest(){
        assertNull(GeoPoliticalZone.findZone("London"));
    }

    @Test
    public void checkUserState_AndTrimWhiteSpaceTest(){
        assertEquals(GeoPoliticalZone.SOUTH_EAST, GeoPoliticalZone.findZone("  Abia  "));
    }
}
