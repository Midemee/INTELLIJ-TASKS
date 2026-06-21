package linearRegression;

public class LinearRegression {
    int [] hours = {2, 4, 6, 8, 10};
    int [] scores = {50, 60, 70, 80, 95};
    int totalStudents = hours.length;

    public double calculateSumOfHours(){
        double sumOfHours = 0;
        for(int index = 0; index < hours.length; index++){
            sumOfHours += hours[index];
        }
        return sumOfHours;
    }

    public double calculateSumOfScores(){
        double sumOfScores = 0;
        for(int index = 0; index < scores.length; index++){
            sumOfScores += scores[index];
        }
        return sumOfScores;
    }

    public double calculateSumOfHoursAndScores(){
        double sumOfHoursAndScores = 0;
        for(int index = 0; index < hours.length; index++){
            sumOfHoursAndScores += hours[index] * scores[index];
        }
        return sumOfHoursAndScores;
    }

    public double calculateSumOfHoursSquared(){
        double sumOfHoursSquared = 0;
        for (int index = 0; index < hours.length; index++){
            sumOfHoursSquared += hours[index] * hours[index];
        }
        return sumOfHoursSquared;
    }

    public double calculateScorePerHour(){
        double scoresPerHour = (totalStudents * calculateSumOfHoursAndScores() - calculateSumOfHours() * calculateSumOfScores()) / (totalStudents * calculateSumOfHoursSquared() - calculateSumOfHours() * calculateSumOfHours());
        return scoresPerHour;
    }

    public double calculateBaseScore(){
        double baseScore = (calculateSumOfScores() - calculateScorePerHour() * calculateSumOfHours()) / totalStudents;
        return baseScore;
    }

    public double calculatePredictedScore(int userInput){
        double predictedScore = calculateBaseScore() + calculateScorePerHour() * userInput;
        return predictedScore;
    }
}