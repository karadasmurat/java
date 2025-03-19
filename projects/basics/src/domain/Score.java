package domain;

public class Score {
    int value;

    public Score(int value) {
        this.value = value;
    }

    // Utility method to get letter for a primitive int
    public static char getLetterGrade(int score) {

        char letterGrade = ' ';
        if (score >= 90) {
            letterGrade = 'A';
        } else if (score >= 80) {
            letterGrade = 'B';
        } else if (score >= 70) {
            letterGrade = 'C';
        } else if (score >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
        return letterGrade;

    }
}
