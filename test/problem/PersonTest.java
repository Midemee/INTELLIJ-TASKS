package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {
    @Test
    public void personShouldAddProblems(){
        Person person = new Person("David");
        Problem problem = new Problem("Pay rent", ProblemType.FINANCIAL);
        person.addProblem(problem);
        assertEquals(1, person.getProblems().size());
    }

    @Test
    public void personShouldSolveProblemByName(){
        Person person = new Person("David");
        Problem problem = new Problem("Find job", ProblemType.BUSINESS);
        person.addProblem(problem);
        person.solveProblem("Find job");
        assertTrue(problem.isSolved());
    }
}
