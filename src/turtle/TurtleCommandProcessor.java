package turtle;

public class TurtleCommandProcessor {

    private final Turtle turtle;
    private final SketchPad sketchPad;

    public TurtleCommandProcessor(Turtle turtle, SketchPad sketchPad) {
        this.turtle = turtle;
        this.sketchPad = sketchPad;
    }

    public void execute(int... command) {
        switch (command[0]) {
            case 1 -> turtle.movePenUp();

            case 2 -> turtle.movePenDown();

            case 3 -> turtle.turnRight();

            case 4 -> turtle.turnLeft();

            case 5 -> turtle.moveForward(command[1], sketchPad);

            case 6 -> displaySketchPad();

            case 9 -> System.out.println("Program terminated.");

            default -> throw new IllegalArgumentException("Invalid command");
        }
    }

    private void displaySketchPad() {
        int[][] floor = sketchPad.getFloor();

        for (int[] row : floor) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "*" : " ");
            }
            System.out.println();
        }
    }
}
