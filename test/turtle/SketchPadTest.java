package turtle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SketchPadTest {
    private SketchPad sketchPad;
    @BeforeEach
    public void setUp(){
        sketchPad = new SketchPad(20);
    }
    @Test
    public void constructorCreatesTwentyByTwentyFloorTest(){
        assertEquals(20, sketchPad.getFloor().length);
        assertEquals(20, sketchPad.getFloor()[0].length);
    }

    @Test
    public void newSketchPadIsFilledWithZerosTest(){
        int[][] floor = sketchPad.getFloor();

        for(int row = 0; row < floor.length; row++){
            for(int column = 0; column < floor[row].length; column++){
                assertEquals(0, floor[row][column]);
            }
        }
    }

    @Test
    public void getFloorReturnsSameFloorReferenceTest() {
        int[][] floor = sketchPad.getFloor();

        assertSame(floor, sketchPad.getFloor());
    }

    @Test
    public void canModifyFloorThroughGetterTest() {
        sketchPad.getFloor()[5][10] = 1;

        assertEquals(1, sketchPad.getFloor()[5][10]);
    }

    @Test
    public void onlySpecifiedCellChangesTest() {
        sketchPad.getFloor()[3][4] = 1;

        assertEquals(1, sketchPad.getFloor()[3][4]);
        assertEquals(0, sketchPad.getFloor()[3][5]);
        assertEquals(0, sketchPad.getFloor()[2][4]);
    }

    @Test
    public void markPosition_marksSpecifiedCellTest(){
        sketchPad.markPosition(5, 10);
        assertEquals(1, sketchPad.getValueAt(5, 10));
    }

    @Test
    public void markingOnePositionDoesNotAffectOtherPositionsTest(){
        sketchPad.markPosition(5, 10);
        assertEquals(1, sketchPad.getValueAt(5, 10));
        assertEquals(0, sketchPad.getValueAt(5, 11));
        assertEquals(0, sketchPad.getValueAt(4, 10));
    }

    @Test
    public void canMarkMoreThanOnePositionTest(){
        sketchPad.markPosition(2,2);
        sketchPad.markPosition(2,3);
        sketchPad.markPosition(2,4);

        assertEquals(1, sketchPad.getValueAt(2, 2));
        assertEquals(1, sketchPad.getValueAt(2, 3));
        assertEquals(1, sketchPad.getValueAt(2, 4));
    }

}