package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {
    @Test
    public void problemShouldBeCreatedWithNameAndType() {
        Problem problem = new Problem("Pay school fees", ProblemType.EDUCATION);
        assertEquals("Pay school fees", problem.getProblemName());
        assertEquals(ProblemType.EDUCATION, problem.getProblemType());
        assertFalse(problem.isSolved());
    }

    @Test
    public void problemShouldBecomeSolved(){
        Problem problem = new Problem("Pay school fees", ProblemType.EDUCATION);
        problem.solvedProblem();
        assertTrue(problem.isSolved());
    }
}

