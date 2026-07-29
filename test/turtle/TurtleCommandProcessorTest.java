package turtle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurtleCommandProcessorTest {

    private Turtle turtle;
    private SketchPad sketchPad;
    private TurtleCommandProcessor processor;

    @BeforeEach
    public void setUp() {
        turtle = new Turtle();
        sketchPad = new SketchPad(20);
        processor = new TurtleCommandProcessor(turtle, sketchPad);
    }

    @Test
    public void commandOneRaisesPenTest() {
        turtle.movePenDown();

        processor.execute(1);

        assertTrue(turtle.penIsUp());
    }

    @Test
    public void commandTwoLowersPenTest() {
        processor.execute(2);

        assertFalse(turtle.penIsUp());
    }

    @Test
    public void commandThreeTurnsRightTest() {
        processor.execute(3);

        assertEquals(Directions.SOUTH, turtle.getCurrentDirection());
    }

    @Test
    public void commandFourTurnsLeftTest() {
        processor.execute(4);

        assertEquals(Directions.NORTH, turtle.getCurrentDirection());
    }

    @Test
    public void commandFiveMovesForwardTest() {
        processor.execute(5, 4);

        assertEquals(4, turtle.getPosition().getColumnPosition());
    }

    @Test
    public void commandFiveWithPenDownDrawsTest() {
        processor.execute(2);
        processor.execute(5, 3);

        assertEquals(1, sketchPad.getValueAt(0,0));
        assertEquals(1, sketchPad.getValueAt(0,1));
        assertEquals(1, sketchPad.getValueAt(0,2));
        assertEquals(1, sketchPad.getValueAt(0,3));
    }

    @Test
    public void invalidCommandThrowsExceptionTest() {
        assertThrows(IllegalArgumentException.class,
                () -> processor.execute(10));
    }
}