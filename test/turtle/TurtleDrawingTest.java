package turtle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurtleDrawingTest {

    private Turtle turtle;
    private SketchPad sketchPad;

    @BeforeEach
    public void setUp() {
        turtle = new Turtle();
        sketchPad = new SketchPad(20);
    }

    @Test
    public void penUp_moveForwardDoesNotDrawTest() {
        turtle.moveForward(5, sketchPad);

        assertEquals(0, sketchPad.getValueAt(0,0));
        assertEquals(0, sketchPad.getValueAt(0,5));
    }

    @Test
    public void penDown_moveOneStep_drawsStartingPositionAndEndingPositionTest() {
        turtle.movePenDown();

        turtle.moveForward(1, sketchPad);

        assertEquals(1, sketchPad.getValueAt(0,0));
        assertEquals(1, sketchPad.getValueAt(0,1));
    }

    @Test
    public void penDown_moveFiveSteps_drawsHorizontalLineTest() {
        turtle.movePenDown();

        turtle.moveForward(5, sketchPad);

        for (int column = 0; column <= 5; column++) {
            assertEquals(1, sketchPad.getValueAt(0,column));
        }
    }

    @Test
    public void penDown_turnRight_moveThreeSteps_drawsVerticalLineTest() {
        turtle.movePenDown();

        turtle.turnRight();
        turtle.moveForward(3, sketchPad);

        for (int row = 0; row <= 3; row++) {
            assertEquals(1, sketchPad.getValueAt(row,0));
        }
    }

    @Test
    public void penUpAfterDrawing_stopsDrawingTest() {
        turtle.movePenDown();
        turtle.moveForward(2, sketchPad);

        turtle.movePenUp();
        turtle.moveForward(2, sketchPad);

        assertEquals(1, sketchPad.getValueAt(0,0));
        assertEquals(1, sketchPad.getValueAt(0,1));
        assertEquals(1, sketchPad.getValueAt(0,2));

        assertEquals(0, sketchPad.getValueAt(0,3));
        assertEquals(0, sketchPad.getValueAt(0,4));
    }
}