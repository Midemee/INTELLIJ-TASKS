package turtle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurtleTest {
    private Turtle turtle;
    @BeforeEach
    public void SetUp(){
        turtle = new Turtle();
    }
    @Test
    public void turtleStartsWithPenUpTest(){
        assertTrue(turtle.penIsUp());
    }

    @Test
    public void movePenDown_penShouldBeDownTest(){
        turtle.movePenDown();
        assertFalse(turtle.penIsUp());
    }

    @Test
    public void movePenDownThenMovePenUp_penShouldBeUpTest(){
        turtle.movePenDown();
        turtle.movePenUp();

        assertTrue(turtle.penIsUp());
    }

    @Test
    public void turtleStartsFacingEastTest(){
        assertEquals(Directions.EAST, turtle.getCurrentDirection());
    }

    @Test
    public void turnRightFromEast_facesSouthTest(){
        turtle.turnRight();
        assertEquals(Directions.SOUTH, turtle.getCurrentDirection());
    }

    @Test
    public void turnRightFourTimes_facesEastAgainTest() {
        turtle.turnRight();
        turtle.turnRight();
        turtle.turnRight();
        turtle.turnRight();

        assertEquals(Directions.EAST, turtle.getCurrentDirection());
    }

    @Test
    public void turnLeftFromEast_facesNorthTest() {
        turtle.turnLeft();

        assertEquals(Directions.NORTH, turtle.getCurrentDirection());
    }

    @Test
    public void turnLeftFourTimes_facesEastAgainTest() {
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();

        assertEquals(Directions.EAST, turtle.getCurrentDirection());
    }

    @Test
    public void moveForwardFacingEast_changesColumnPositionTest() {
        turtle.moveForward(5);

        assertEquals(5, turtle.getPosition().getColumnPosition());
        assertEquals(0, turtle.getPosition().getRowPosition());
    }

    @Test
    public void moveForwardFacingSouth_changesRowPositionTest() {
        turtle.turnRight();

        turtle.moveForward(6);

        assertEquals(6, turtle.getPosition().getRowPosition());
        assertEquals(0, turtle.getPosition().getColumnPosition());
    }

    @Test
    public void moveForwardFacingWest_decreasesColumnPositionTest() {
        turtle.turnRight();
        turtle.turnRight();

        turtle.moveForward(4);

        assertEquals(-4, turtle.getPosition().getColumnPosition());
        assertEquals(0, turtle.getPosition().getRowPosition());
    }

    @Test
    public void moveForwardFacingNorth_decreasesRowPositionTest() {
        turtle.turnLeft();

        turtle.moveForward(3);

        assertEquals(-3, turtle.getPosition().getRowPosition());
        assertEquals(0, turtle.getPosition().getColumnPosition());
    }

    @Test
    public void turnRightThenTurnLeft_facesEastAgainTest() {
        turtle.turnRight();
        turtle.turnLeft();

        assertEquals(Directions.EAST, turtle.getCurrentDirection());
    }

    @Test
    public void movePenDownTurnRightMoveForward_penRemainsDownTest() {
        turtle.movePenDown();
        turtle.turnRight();
        turtle.moveForward(5);

        assertFalse(turtle.penIsUp());
    }

}
