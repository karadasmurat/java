package mk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import exercises.Exercise;

public class Basics {

    public boolean isRaining() {
        System.out.println("Checking rain..");
        return true;
    }

    public boolean isSnowing() {
        System.out.println("Checking snow..");
        return true;
    }

    public void variableBasics() {

        System.out.println("Variable Basics");
        System.out.println("---------------");

        // Declaration
        int number;
        String str = null;

        // you must assign a value before using it in your code.
        System.out.println(str); // OK, prints "null"

        // Null pointer access!
        System.out.println(str.length()); // Runtime Exception in thread "main" java.lang.NullPointerException:

        //

        byte b = 127; // 8-bit signed
        short s = 1; // 16-bit signed
        int i = 2_000_000; // OK: underscores _ as digit separators
        var n = Integer.valueOf("1234"); // OK
        // var n = Integer.valueOf("1_234"); // ERR
        System.out.println(n);

        int big = Integer.MAX_VALUE; // 2147483647
        System.out.println("Integer.MAX_VALUE: " + big);

        long l = 0L; // 64-bit An integer literal is of type long if it ends with the letter L or l;

        float f = 0.0F;
        double d = 0.0;

        boolean result = true;
        char capitalC = 'C';
        char euro = '\u20AC'; // €: 16-bit (4*hex) Unicode Escape Sequence

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(result);
        System.out.println(capitalC);
        System.out.println(euro); //

        // type inference
        var myNumber = 99; // The compiler infers that myNumber is of type int
        var list = new ArrayList<String>(); // infers ArrayList<String>

        // primitives hold actual value
        int x1 = 9;
        int x2 = x1; // value is COPIED
        x1 = 10;
        System.out.printf("x1: %d x2: %d\n", x1, x2); // x1: 10 x2: 9

        // objects are different
        Tank t1 = new Tank(9);
        Tank t2 = t1; // assign one object to another copies reference
        Tank t3 = null;
        t1.setLevel(10);
        System.out.printf("t1: %d t2: %d\n", t1.getLevel(), t2.getLevel()); // t1: 10 t2: 10

        Integer myInt = Integer.valueOf(10);
        int score = Integer.parseInt("99");

        System.out.println("int score from String: " + score); // int score from String: 99

        // Convert the Integer object to a primitive int
        int intValue = myInt.intValue();

        // Convert the Integer object to a double
        double doubleValue = myInt.doubleValue();

        System.out.println("int: " + intValue + " double: " + doubleValue); // int: 10 double: 10.0

        System.out.println("Initialization");
        // instance variables, initialization
        Product product1 = new Product(); // default constructor
        System.out.println("code: " + product1.getCode());
        System.out.println("stock: " + product1.getStock());

        // casting
        int num1 = 100;
        double myDouble = num1; // Implicit casting (int to double)
        System.out.println("myDouble: " + myDouble);

        double myOtherDouble = 3.14;
        int num2 = (int) myOtherDouble; // Explicit casting (double to int)
        // Note: This might result in data loss (decimal part will be truncated)
        System.out.println("(int) 3.14: " + num2);
    }

    public void operatorBasics() {
        System.out.println("Operator Basics");
        System.out.println("---------------");

        int x = -1;

        System.out.printf("x: %d binary: %s\n", x, Integer.toBinaryString(x));

        x = 255;
        System.out.printf("x: %d binary: %s\n", x, Integer.toBinaryString(x));

        x = 1;
        x <<= 2; // shift all the bits in x two positions to the left
        System.out.printf("x: %d binary: %s\n", x, Integer.toBinaryString(x));

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

        // short-cutting
        if (isRaining() || isSnowing()) {
            System.out.println("Better stay at home.");
        } else {
            System.out.println("Lets go out!");
        }
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

        InstanceCounter ic1 = new InstanceCounter();
        InstanceCounter ic2 = new InstanceCounter();
        InstanceCounter ic3 = new InstanceCounter();

        // Get and print the total number of instances created
        System.out.println("Total instances: " + InstanceCounter.getCount());

        Car car1 = new Car("Kia", "Sorento", 2007);
        Car car2 = car1;
        car1.setYear(2025);
        System.out.println(car1);
        System.out.println(car2);

        Car car3 = new Car("Kia", "Sorento", 2007);
        Car car4 = car3; // Both tank1 and tank2 refer to the same object
        car3 = new Car("Tesla", "Model Y", 2024); // car3 now refers to a different object.
        System.out.println(car3); // Car(Tesla, Model Y, 2024)
        System.out.println(car4); // Car(Kia, Sorento, 2007)

    }

    public void genericsBasics() {
        System.out.println("Generics Basics");
        System.out.println("---------------");

        GenericBox<Integer> box = new GenericBox<>(0);
        System.out.println(box.getValue());

    }

    public void containerBasics() {
        listBasics();
    }

    public void listBasics() {
        System.out.println("List Basics");
        System.out.println("-----------");

        List<String> names = new ArrayList<>();

        // check if the collection contains elements
        if (names.isEmpty()) {
            System.out.println("Collection contains no elements.");
        }

        // add elements to the list
        names.add("Ron");
        names.add("Harry");
        names.add("Ron"); // Duplicates are allowed in List

        System.out.println(names); // [[Ron, Harry, Ron]

        // the number of elements in this collection
        System.out.println(names.size()); // 3

        // Remove by object
        names.remove("Ron");

        System.out.println(names); // [Harry, Ron]

        // Inserts the specified element at the specified position
        names.add(1, "Hermione");

        // Inserts all of the elements in the specified collection
        String[] candidates = { "Draco", "Crabbe", "Goyle" };
        names.addAll(Arrays.asList(candidates));
        System.out.println(names); // [Harry, Hermione, Ron, Draco, Crabbe, Goyle]

        // Access the element at the specified position in this list.
        System.out.println(names.get(1)); // Hermione

        // Gets the last element of this collection.
        System.out.println("Last element: " + names.getLast()); // Goyle
        System.out.println("Last element: " + names.get(names.size() - 1)); // Goyle

        // check if the collection contains the specified element
        if (names.contains("Hermione")) {
            System.out.println("collection contains the specified element.");
        }

        // Adds an element as the first element
        names.addFirst("FirstElement");
        System.out.println(names); // [FirstElement, Harry, Hermione, Ron, Draco, Crabbe, Goyle]

        // Setter: Replaces the element at the specified position
        names.set(0, "Hagrid");

        // Removes the element at the specified position
        names.remove(6);
        System.out.println(names); // [Hagrid, Harry, Hermione, Ron, Draco, Crabbe]

        // Removes the first occurrence of the specified element
        names.remove("Crabbe");
        System.out.println(names); // [Hagrid, Harry, Hermione, Ron, Draco]

        // the index of the first occurrence of the specified element, or -1
        System.out.println("Harry is at index:" + names.indexOf("Harry")); // 1

        // Count the number of elements in the specified collection
        System.out.println(Collections.frequency(names, "Harry")); // 1

        // Reverses the order of the elements in the specified list.
        Collections.reverse(names);

        // Iterate through collection
        for (var s : names) {
            System.out.println(s);
        }
    }

    public void exercises() {
        System.out.println("Exercises");
        System.out.println("---------");

        Exercise exercise = new Exercise();
        // exercise.countTo(5);
        boolean check = exercise.isPrime(2);
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
