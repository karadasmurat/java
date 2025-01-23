package mk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import exercises.Exercise;
import tmp.Tmp;

public class Basics {

    public int getMax(int a, int b) {

        // conditional logic within a method's return statement
        return (a > b) ? a : b;
    }

    public boolean isRaining() {
        System.out.println("Checking rain..");
        return true;
    }

    public boolean isSnowing() {
        System.out.println("Checking snow..");
        return true;
    }

    public static void modifyArray(int[] arr) {
        arr[0] = 100; // Modifies the first element of the array
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
        // System.out.println(str.length()); // Runtime Exception in thread "main"
        // java.lang.NullPointerException:

        //

        byte b = 127; // 8-bit signed
        // byte b2 = 2025; // Compilation ERR: Type mismatch: cannot convert from int to
        // byte
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
        System.out.println("(int) 3.14: " + num2); // 3

        int num3 = Double.valueOf(myOtherDouble).intValue();
        System.out.println("Double.intValue() " + num3); // 3

        char ch = 'A';
        int asciiValue = ch; // Implicitly converts 'A' to its ASCII value (65)
        // short asciiValue = (short) ch; // Implicitly converts 'A' to its ASCII value
        // (65)

        System.out.println("'A': " + asciiValue); // Output: 65

        // blank final variable
        // declare a final variable without initializing it immediately:
        final int finalVar;

        int var1 = 1;
        int var2 = 2;

        // initialization of final variable
        if (var1 > var2) {
            finalVar = 1;
        } else {
            finalVar = -1;
        }
        System.out.println("finalVar: " + finalVar); // finalVar: -1
    }

    public void operatorBasics() {
        System.out.println("Operator Basics");
        System.out.println("---------------");

        int x = -1;

        System.out.printf("x: %d binary: %s\n", x, Integer.toBinaryString(x));

        x = 255;
        System.out.printf("x: %d binary: %s\n", x, Integer.toBinaryString(x));

        var res1 = 23 / 5; // 4 - res is integer
        var res2 = 23L / 5; // 4 - res is long
        var res3 = 23D / 5; // 4.6 - res is double

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

        int a = 0;
        int b = a++;

        System.out.printf("a:%d  b:%d\n", a, b); // a:1 b:0

        // ternary operator ? :
        // assign this or that
        int score = 75;
        String grade = score >= 60 ? "Pass" : "Fail";
        System.out.println(grade);

        // complex ternary
        int score1 = 50;
        int score2 = 70;
        int score3 = 90;

        boolean cond = score1 < score2 ? score1 < score3 ? true : false : false;
        // boolean res = score1 < score2 ? (score1 < score3 ? true : false) : false;
        if (cond) {
            System.out.println("score1 is the smallest");
        }

        // bitwise
        int x1 = 4; // ...0100
        int x2 = 8; // ...1000

        int k = x1 & x2; // ...0000
        System.out.printf("%d: %s\n", k, Integer.toBinaryString(k)); // 0: 0

        k = x1 | x2; // ...1100
        System.out.printf("%d: %s\n", k, Integer.toBinaryString(k)); // 12: 1100

        k = x1 << 2; // shift all the bits in x1 two positions to the left
        System.out.printf("%d: %s\n", k, Integer.toBinaryString(k)); // 16: 10000

        x1 >>= 1; // shift all the bits in x1 two positions to the right
        System.out.printf("%d: %s\n", x1, Integer.toBinaryString(x1)); // 2: 10

        // Precedence
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = false;

        boolean b4 = b1 & b2 | b3;
        System.out.println(b4); // false

        // The value of this expression depends on
        // whether we evaluate the || first or the && first.
        boolean b5 = b1 || b2 && b3;
        boolean b5_ok = b1 || (b2 && b3); // in Java, the && operator has higher precedence than the || operator.
        boolean b5_nok = (b1 || b2) && b3;

        assert b5 == b5_ok;
        assert b5 != b5_nok;

        // Operator overloading: String concatenation (+)
        // String + int: The integer 1 is implicitly converted to its string
        // representation ("1")
        String s1 = "Java" + 1; // Java1
        String s2 = 1 + 2 + "Java"; // 3Java
        String s3 = "Java" + 1 + 2; // Java12
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        char c1 = 'A';
        char c2 = 'B';
        var c3 = c1 + c2; // 131 - note that c3 is int
        System.out.println(c3);

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
        // both ways are valid
        int[] anArray; // generally preferred
        int numbers[]; // less common

        Object[] ao; // array of Object
        Collection<?>[] ca; // array of Collection of unknown type

        // allocate memory for 10 integers
        anArray = new int[10];

        // Initialization: When an array of primitive data types (like int, double,
        // boolean, etc.) is created using new, the elements are initialized to their
        // default values.
        numbers = new int[10];

        // Arrays utility to print a string representation
        System.out.println(Arrays.toString(numbers)); // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        // The array's length is available as a final instance variable length.
        System.out.println("numbers.length:" + numbers.length);

        // initialize first element
        anArray[0] = 100;

        // access the first element
        System.out.println("Element at index 0: " + anArray[0]);

        // shortcut syntax to create and initialize an array:

        int[] scores = { 30, 50, 60, 80, 90, 100 };
        int[] factorial = { 1, 1, 2, 6, 24, 120, 720, 5040 };

        // Iterate through the array using a for-each loop
        System.out.println("\nIterate using for-each loop:");
        for (int number : scores) {
            System.out.println(number);
        }

        // varargs
        int total = total();
        // int total = total(1, 2, 3, 4, 5);
        System.out.println("Total: " + total);

        // Pass by reference
        int[] elements = { 1, 2, 3 };
        System.out.println("Before modification: " + Arrays.toString(elements)); // [1, 2, 3]

        modifyArray(elements);

        System.out.println("After modification: " + Arrays.toString(elements)); // [100, 2, 3]

        int[] valuesA = { 1, 2, 3, 4, 5 };

        // Array Reference Assignment:
        // After this, valuesA and valuesB point to the same array object in memory.
        // So, when you assign one array variable to another, you're essentially
        // assigning a
        // reference to the same array object.
        // int[] valuesB = valuesA;

        // Arrays are cloneable
        int[] valuesC = valuesA.clone();

        // check if valuesA and valuesB refer to the same array object in memory.
        // System.out.println("valuesA == valuesB: " + (valuesA == valuesB)); // true
        System.out.println("valuesC == valuesA: " + (valuesC == valuesA)); // false

        // This modifies the array referenced by both valuesA and valuesB.
        // valuesA[0] = 9;

        System.out.println("valuesA: " + Arrays.toString(valuesA)); // [9, 2, 3, 4, 5]
        // System.out.println("valuesB: " + Arrays.toString(valuesB)); // [9, 2, 3, 4,
        // 5] // modified through valuesA
        System.out.println("valuesC: " + Arrays.toString(valuesC)); // [1, 2, 3, 4, 5]

        // Multi dimensional arrays
        // A single variable of array type may contain references to arrays of different
        // lengths,
        // because an array's length is not part of its type.
        int[] arrA = { 1, 2, 3 };
        int[] arrB = { 10, 20 };

        int[][] array2D = { arrA, arrB };

        // accessing subarrays and their elements
        // The first element of the array3, which refers to array1
        System.out.println("array3[0]: " + Arrays.toString(array2D[0])); // [1, 2, 3]
        // Second element (index 1) of array3[0], which is array1
        System.out.println("array3[0][1]: " + array2D[0][1]); // 2

        // iterating 2d array
        for (var row : array2D) {
            for (var cell : row) {
                System.out.println(cell);
            }
        }

        var arrClone = array2D.clone();

        // check if clone and original refer to the same array object in memory: NO
        System.out.println("arrClone == array3: " + (arrClone == array2D)); // false

        // check if clone and original share subarrays: YES
        System.out.println("arrClone[0] == array3[0]: " + (arrClone[0] == array2D[0])); // true

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

    public void switchBasics() {
        String sizeStr = "NA";
        int size = 4;

        switch (size) {
            case 1:
                sizeStr = "S";
                break;

            case 2:
                sizeStr = "M";
                break;

            case 3:
                sizeStr = "L";
                break;

            default:
                sizeStr = "DEFAULT";

        }
        System.out.println("Size: " + sizeStr);

        // what if we remove break statements?
        int dayOfWeek = 4;

        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
            case 2:
                System.out.println("Tuesday");
            case 3:
                System.out.println("Wednesday");
            case 4:
                System.out.println("Thursday");
            case 5:
                System.out.println("Friday");
            case 6:
                System.out.println("Saturday");
            case 7:
                System.out.println("Sunday");
            default:
                System.out.println("Invalid day");
        }

        int year = 6;
        switch (year) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Primary School");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Secondary School");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("High School");
                break;

            default:
                System.out.println("Higher Education");
        }

        // switch expressions
        int dayNo = 3;
        String dayName = switch (dayNo) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };

        System.out.println(dayName); // Output: Wednesday

        int schoolYear = 10;
        String schoolName = switch (schoolYear) {
            case 1, 2, 3, 4, 5 -> "Primary School";
            case 6, 7, 8 -> "Secondary School";
            case 9, 10, 11 -> "High School";
            default -> "Higher Education";
        };

        System.out.println(schoolName); // Output: High School
    }

    public void loopBasics() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Count is: " + i);
        }

        // while (true) {
        // // Code to be executed repeatedly
        // System.out.println("This loop will run forever.");

        // }

        // break statement
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
        }

        // continue statement
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
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
        // boolean check = exercise.isPrime(2);
        // exercise.drawRect('*', 5, 3);
        exercise.drawTriangle('*', 5);
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

    public void test() {
        System.out.println("Test");
        Tmp t = new Tmp();

    }
}
