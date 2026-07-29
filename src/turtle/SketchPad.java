package turtle;

public class SketchPad {
    private final int [][] floor;
    public SketchPad(int size){
        floor = new int[size][size];
    }

    public int[][] getFloor(){
        return floor;
    }

    public void markPosition(int row, int column){
        floor[row][column] = 1;
    }

    public int getValueAt(int row, int column){
        return floor[row][column];
    }
}
