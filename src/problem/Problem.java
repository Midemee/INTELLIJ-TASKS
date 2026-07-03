package problem;

public class Problem {
    private String problemName;
    private ProblemType problemType;
    private boolean isSolved;

    public Problem(String problemName, ProblemType problemType){
        this.problemName = problemName;
        this.problemType = problemType;
        this.isSolved = false;
    }

    public String getProblemName(){
        return problemName;
    }

    public ProblemType getProblemType(){
        return problemType;
    }

    public boolean isSolved(){
        return isSolved;
    }

    public void solvedProblem(){
        isSolved = true;
    }
}
