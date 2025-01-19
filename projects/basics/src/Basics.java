public class Basics {
    public void variableBasics() {
        byte b = 127; // 8-bit signed
        short s = 1; // 16-bit signed
        int i = 2; // 32-bit signed
        long l = 0L; // 64-bit An integer literal is of type long if it ends with the letter L or l;

        float f = 0.0F;
        double d = 0.0;

        boolean result = true;
        char capitalC = 'C';

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(result);
        System.out.println(capitalC);

    }

    public void arrayBasics() {

        System.out.println("Array Basics");
        System.out.println("------------");

        // declare an array of integers
        int[] anArray;

        // allocate memory for 10 integers
        anArray = new int[10];

        // initialize first element
        anArray[0] = 100;

        // access the first element
        System.out.println("Element at index 0: " + anArray[0]);

        // shortcut syntax to create and initialize an array:

        int[] scores = { 30, 50, 60, 80, 90, 100 };

        // Iterate through the array using a for-each loop
        System.out.println("\nIterate using for-each loop:");
        for (int number : scores) {
            System.out.println(number);
        }

        // varargs
        int total = total();
        // int total = total(1, 2, 3, 4, 5);
        System.out.println("Total: " + total);
    }

    public void controlFlowBasics() {
        int score = 88;
        String grade = getGrade(score);
        System.out.println(grade);

        String daystr = getDayOfWeek(6);
        System.out.println(daystr);
    }

    public void loopBasics() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Count is: " + i);
        }

        while (true) {
            // Code to be executed repeatedly
            System.out.println("This loop will run forever.");

        }
    }

    private String getGrade(int score) {

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Invalid score: " + score);
        }

        String grade = "NA";

        if (score > 90) {
            grade = "A";
        } else if (score > 80) {
            grade = "B";
        } else if (score > 70) {
            grade = "C";
        } else if (score > 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        return grade;
    }

    public String getDayOfWeek(int d) {

        if (d < 0 || d > 7) {
            throw new IllegalArgumentException("Invalid day of week: " + d);
        }

        String dayStr = "NA";
        switch (d) {
            case 1:
                dayStr = "MON";
                break;
            case 2:
                dayStr = "TUE";
                break;
            case 3:
                dayStr = "WED";
                break;
            case 4:
                dayStr = "THU";
                break;
            case 5:
                dayStr = "FRI";
                break;
            case 6:
                dayStr = "SAT";
                break;
            case 7:
                dayStr = "SUN";
                break;

            default:
                break;
        }

        return dayStr;

    }

    // Calculate the sum of all the given integers.
    public int total(int... nums) {
        if (nums.length == 0)
            return 0;

        int sum = 0;

        // vararg is treated as an array of the specified data type.
        for (int n : nums) {
            sum += n;
        }

        return sum;
    }
}
