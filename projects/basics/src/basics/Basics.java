package basics;

import java.util.Random;

import basics.OuterClass.InnerClass;

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

        Integer myInt = Integer.valueOf(10);
        int score = Integer.parseInt("99");

        System.out.println("int score from String: " + score); // int score from String: 99

        // Convert the Integer object to a primitive int
        int intValue = myInt.intValue();

        // Convert the Integer object to a double
        double doubleValue = myInt.doubleValue();

        System.out.println("int: " + intValue + " double: " + doubleValue); // int: 10 double: 10.0

    }

    public void mathBasics() {
        double a = -191.635;
        double b = 43.74;
        int c = 16;
        int d = 45;

        System.out.printf("The absolute value of %.3f is %.3f%n", a, Math.abs(a));
        System.out.printf("The ceiling of %.2f is %.0f%n", b, Math.ceil(b));
        System.out.printf("The floor of %.2f is %.0f%n", b, Math.floor(b));

        System.out.printf("The max of %d and %d is %d%n", c, d, Math.max(c, d));
        System.out.printf("The min of of %d and %d is %d%n", c, d, Math.min(c, d));

        // Math.random works well when you need to generate a single random number.
        int rand = (int) (Math.random() * 10) + 1;
        System.out.println("Math.random(): " + rand);
    }

    public void stringBasics() {
        System.out.println("String Basics");
        System.out.println("-------------");

        String initials = "MK";

        int len = initials.length(); // the number of characters contained in the string object

        // Concatenating Strings
        String s1 = "Hello ";
        String s2 = "world";
        // v1:
        String s3 = s1 + s2;
        System.out.println("Concat using +: " + s3);

        // v2
        String s4 = s1.concat(s2);
        System.out.println("Concat using +: " + s4);

        // Getting Characters and Substrings by Index
        char firstChar = s1.charAt(0); // H
        System.out.println("First char: " + firstChar);

        // Returns a new string that is a substring of this string
        String substr = s1.substring(0, 2); // He
        System.out.println("substring(0, 2): " + substr);

        // Split into an array of Strings
        String FPATH = "home/user/index.html";
        String[] words = FPATH.split("/");
        for (String w : words) {
            System.out.println(w);
        }

        // Returns a new string resulting from replacing all occurrences of oldChar
        String path2 = FPATH.replace('/', '>'); // home>user>index.html
        System.out.println("path2: " + path2);

        // creates empty StringBuilder, capacity 16
        StringBuilder sb = new StringBuilder();

        System.out.printf("length: %d capacity: %d", sb.length(), sb.capacity()); // length: 0 capacity: 16

        // adds 9 character string at beginning
        sb.append("Greetings");

        System.out.printf("length: %d capacity: %d", sb.length(), sb.capacity()); // length: 9 capacity: 16

        System.out.println(sb.toString()); // Greetings
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

    public void classBasics() {

        Rectangle rect = new Rectangle(5, 10);
        int area = rect.getArea();
        System.out.println("Area: " + area);

        // Nested Classes
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.accessMembersOfOuter();
    }

    public void genericsBasics() {
        System.out.println("Generics Basics");
        System.out.println("---------------");

        GenericBox<Integer> box = new GenericBox<>(0);
        System.out.println(box.getValue());

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

    @Deprecated
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
