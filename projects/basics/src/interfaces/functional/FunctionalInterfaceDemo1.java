package interfaces.functional;

import java.util.function.Predicate;

class Score {
    int value;

    public Score(int value) {
        this.value = value;
    }

    // instance method
    public boolean hasPassed() {
        System.out.println("hasPassed()");
        return this.value > 60;
    }

    // static utility method
    public static boolean checkUtility(Integer score) {
        System.out.println("checkUtility()");
        return score > 60;
    }
}

public class FunctionalInterfaceDemo1 {

    // Implementing Predicate.test(T)
    // score -> score > 60
    public static boolean hasPassed(int score) {
        return score > 60;
    }

    public static void main(String[] args) {

        // Lambda creating a close!
        // Variable used in lambda should be final or effectively final.
        // The lambda does not modify the captured variable but can use it.
        int threshold = 60;

        Predicate<Integer> predicate1a = x -> x > threshold;

        // use an existing static utility method in lambda
        Predicate<Integer> predicate2a = x -> Score.checkUtility(x);

        // use an existing instance method in lambda
        Predicate<Score> predicate3a = x -> x.hasPassed();

        // method reference
        Predicate<Integer> predicate1b = FunctionalInterfaceDemo1::hasPassed;

        // use an existing static utility method reference
        Predicate<Integer> predicate2b = Score::checkUtility;

        // use an existing instance method reference
        Predicate<Score> predicate3b = Score::hasPassed;

        Integer scoreVAL = 65;
        Score scoreOBJ = new Score(scoreVAL);

        if (predicate3a.test(scoreOBJ)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
