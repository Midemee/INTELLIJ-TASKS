package problem;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Problem> problems;
    private int count;

    public Person(String name){
        this.name = name;
        problems = new ArrayList<>();
    }

    public void addProblem(Problem problem){
        problems.add(problem);
    }

    public List<Problem> getProblems(){
        return problems;
    }

    public void solveProblem(String problemName){
        for(Problem currentProblem : problems){
            if(currentProblem.getProblemName().equalsIgnoreCase(problemName)){
                currentProblem.solvedProblem();
            }
        }
    }

    public void unresolvedProblems(){
        for(Problem currentProblem : problems){
            if(!currentProblem.isSolved()){
                currentProblem.getProblemName();
            }
        }
    }
}
