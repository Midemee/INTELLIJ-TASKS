package linearRegression;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinearRegressionTest {
    LinearRegression data = new LinearRegression();
    @Test
    public void testThatIhaveArrayOfHoursAndItsGivesTheSumOfHours(){
       assertEquals(30, data.calculateSumOfHours());
    }

    @Test
    public void testThatIHaveArrayOfScoresAndItsGivesTheSumOfScores(){
        assertEquals(355, data.calculateSumOfScores());
    }

    @Test
    public void testThatIHaveTwoArraysOfHoursAndScoresAndItGivesTheSumOfItsProduct(){
        assertEquals(2350, data.calculateSumOfHoursAndScores());
    }

    @Test
    public void testThatIHaveTwoArraysOfHoursAndItGivesSumOfHoursSquared(){
        assertEquals(220, data.calculateSumOfHoursSquared());
    }

    @Test
    public void testThatIHaveTwoArraysOfHoursAndScoresAndItGivesCorrectScorePerHour(){
        assertEquals(5.5, data.calculateScorePerHour());
    }

    @Test
    public void testThatIHaveTwoArraysOfHoursAndScoresAndItGivesCorrectBaseScore(){
        assertEquals(38.0, data.calculateBaseScore());
    }

    @Test
    public void testThatIHaveTwoArraysOfhoursAndScoresAndItGivesCorrectPredictedScore(){
        assertEquals(54.5, data.calculatePredictedScore(3));
    }
}
