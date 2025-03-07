package mk;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import access.one.B;
import collections.ListDemo;
import domain.Car;
import domain.Product;
import domain.Rectangle;
import domain.Tank;
import dsa.StackMK;
import exercises.Exercise;
import generics.GenericBox;
import patterns.User;
import relationships.Country;
import relationships.Course;
import relationships.President;
import relationships.Student;
import util.Util;
import inheritance.*;

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

    public int getAnInt() {
        return 333;
    }

    public byte getAByte() {
        byte b = 1;
        return b;
    }

    public void accessBasics() {
        Util.header("Access Basics");

        B b = new B();
        b.test();
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

        int $OK2Identifier;
        int _alsoOK1d3ntifi3r;
        int __SStillOkbutKnotsonice$;
        int Public = 0;

        // invalid identifiers
        // int 3DPointClass; // identifiers cannot begin with a number
        // int hollywood@vine; // @ is not a letter, digit, $ or _
        // int *$coffee; // * is not a letter, digit, $ or _
        // public // public is a reserved word
        // int 1980_s = 0;

        boolean true_ = false;
        System.out.println("true_:" + true_);

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

        int hexVal = 0xFF;
        int binaryVal = 0b100;
        int octalVal = 0100; // Prefix: zero

        System.out.println("0xFF: " + hexVal); // 255
        System.out.println("0b100: " + binaryVal); // 4
        System.out.println("0100: " + octalVal); // 64

        long l = 0L; // 64-bit An integer literal is of type long if it ends with the letter L or l;

        float f = 0.0F;
        double d = 0.0;

        double d2 = 10; // automatic promotion to double
        double d3 = 0xF; // automatic promotion to double
        System.out.println("double 10: " + d2);
        System.out.println("double 0xF: " + d3);

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

        // double notAtStart = _1000.00; // DOES NOT COMPILE
        // double notAtEnd = 1000.00_; // DOES NOT COMPILE
        // double notByDecimal = 1000_.00; // DOES NOT COMPILE

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

        // widening - implicit
        int res1 = getAByte();
        System.out.println(res1);

        // short res2 = getAnInt(); // ERR Type mismatch: cannot convert from int to
        // short

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

        // assign to null
        // int value = null; // DOES NOT COMPILE
        String s5 = null;

        String firstname, lastname;
        int c1 = 1, c2 = 2;

        // Only i3 was initialized: i3. The other two remain declared but not yet
        // initialized.
        int i1, i2, i3 = 11;

        String s1 = "1", s2;

        // if (s2 == null) { // ERR The local variable s2 may not have been initialized.
        // System.out.println("s2 is null!");
        // }

        // double d1, double d2; // Syntax error on token "," ; expected

        initializeVariables();
    }

    public void initializeVariables() {

        // The compiler is also smart enough to recognize initializations that are more
        // complex.
        boolean check = true;
        int answer; // local variable, declared within methods or blocks, must be explicitly
                    // initialized before their first use
        int onlyOneBranch;
        if (check) {
            onlyOneBranch = 1;
            answer = 1;
        } else {
            answer = 2;
        }
        System.out.println(answer);
        // System.out.println(onlyOneBranch); // DOES NOT COMPILE The local variable may
        // not have been initialized.

    }

    public void acceptInteger(Integer i) {
        System.out.println(i);
    }

    public void wrapperBasics() {
        // Wrapper Classes
        Integer i1 = 1;
        Integer i2 = Integer.valueOf(1);
        Integer i3 = Integer.valueOf("1");

        int i5 = Integer.parseInt("1");
        int i4 = i1.intValue();

        BigDecimal bd1 = new BigDecimal("3.14159");
        BigDecimal bd2 = BigDecimal.valueOf(3.14);

        BigDecimal total = bd1.add(bd2);

        int totalINT = total.intValue();

        System.out.println("Total: " + total + "Total(int): " + totalINT);

        int cnt = 10;
        acceptInteger(cnt); // Works due to autoboxing

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

        int y = 4;
        double res = 3 + 2 * --y;

        System.out.printf("y: %d res: %f\n", y, res); // y: 3 res: 9.0

        // For integer values, division results in the floor value of the nearest
        // integer
        // that fulfills the operation
        System.out.println(10 / 3); // Outputs 3
        System.out.println(11 / 3); // Outputs 3

        // smaller data types are promoted to int when used with a binary arithmetic
        // operator

        short sh1 = 10;
        short sh2 = 3;
        var div1 = sh1 / sh2;
        System.out.println("Short/short: " + div1); // 3

        // float fval = 1.0; // ERR Type mismatch: cannot convert from double to float
        // int x22 = 1.0; // DOES NOT COMPILE
        // short y22 = 1921222; // DOES NOT COMPILE

        // short s10 = 10;
        // short s11 = 3;
        // short z = s10 * s11; // DOES NOT COMPILE Type mismatch cannot convert from
        // int to short

        // int xval = !5; // DOES NOT COMPILE
        // boolean yval = -true; // DOES NOT COMPILE
        // boolean zval = !0; // DOES NOT COMPILE

        long x33 = 10;
        int y33 = 5;
        y33 *= x33; // auto cast

        var res4 = 1L * 1;
        var res5 = 1.0 * 1;

        // attention
        int cnt = 0;
        cnt = cnt++;
        System.out.println("cnt = cnt++: " + cnt); // 0

        int xval = 3;
        int yval = ++xval * 5 / xval-- + --xval;
        System.out.println("Complex unary: " + xval + " " + yval); // 2 7

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

        int READ_FLAG = 4; // rwx: 100
        int WRITE_FLAG = 2; // rwx: 010
        int EXECUTE_FLAG = 1; // rwx: 001

        int permissions_rwx = 7; // rwx: 111
        int permissions_rw = 6; // rwx: 110
        int permissions_r = 4; // rwx: 100

        // check permission (and bitmask)
        if ((permissions_rw & READ_FLAG) == READ_FLAG) {
            System.out.println("Can read.");
        } else {
            System.out.println("Cannot read.");
        }
        if ((permissions_rw & EXECUTE_FLAG) == EXECUTE_FLAG) {
            System.out.println("Can execute.");
        } else {
            System.out.println("Cannot execute.");
        }

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

        // == on different types
        byte byte1 = 0;
        short short1 = 0;
        int int1 = 0;
        long long1 = 0;
        String st1 = "0";

        // Comparison between an int and a long
        // Java automatically promotes int to a long
        // after promotion, they have the same value (0), the condition evaluates to
        // true.
        if (Long.parseLong(st1) == long1) { // ERR Incompatible operand types String and long
            System.out.println("success");
        } else {
            System.out.println("failure");
        }

        // do {
        // int y11 = 1;
        // System.out.print(y++ + " ");
        // } while (y11 <= 10);

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

        double squared = Math.pow(5, 2); // 25.0
        System.out.println("5^2: " + squared); // 5^2: 25.0

        int bigger = Math.max(3, 7); // 7
        int smaller = Math.min(7, -9); // -9

        System.out.println("Max: " + bigger);
        System.out.println("Min: " + smaller);

        // Math.random works well when you need to generate a single random number.
        // returns a value greater than or equal to 0 and less than 1.
        int rand = (int) (Math.random() * 10) + 1;
        System.out.println("Math.random(): " + rand);

        BigInteger big1 = new BigInteger("987654321987654321987654321");
        var bigInt = BigInteger.valueOf(5_000L);
        var bigDecimal = BigDecimal.valueOf(5_000L);
        bigDecimal = BigDecimal.valueOf(5_000.00);

        // Performing arithmetic operations
        // BigInteger sum = big1.add(big2);
        // BigInteger product = big1.multiply(big2);

        try {
            int var01 = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void randomBasics() {

        System.out.println("Random");
        System.out.println("------");

        Random random = new Random();

        int randomNumber1 = random.nextInt(6); // Generate a random number between 0 (inclusive) and 6 (exclusive)
        System.out.println("Random number 1: " + randomNumber1);

        double randomNumber2 = random.nextDouble(); // Generate a random number between 0.0 and 1.0
        System.out.println("Random number 2: " + randomNumber2);

        boolean randomBoolean = random.nextBoolean();
        System.out.println("Random boolean: " + randomBoolean);
    }

    public void stringBasics() {
        System.out.println("String Basics");
        System.out.println("-------------");

        String initials = "MK";
        String name = new String("Alice");

        int len = initials.length(); // the number of characters contained in the string object

        // String pool
        String str1 = "Java";
        String str2 = "Java";

        String str3 = new String("Java");
        String str4 = new String("Java");

        String str5 = "🙂 Emoji";
        System.out.println(str5);
        System.out.println(str5.charAt(0));
        System.out.println(str5.codePointAt(0)); // 128578
        System.out.println(Character.toChars(128578)); // 🙂

        // referring to the same object?
        stringEquality(str1, str2);
        stringEquality(str3, str4);

        // Concatenating Strings
        String s1 = "Hello ";
        String s2 = "world";
        // v1:
        String s3 = s1 + s2;
        System.out.println("Concat using +: " + s3);

        // v2
        String s4 = s1.concat(s2);
        System.out.println("Concat using +: " + s4);

        System.out.println(1 + 2); // 3
        System.out.println("a" + "b"); // ab
        System.out.println("a" + "b" + 3); // ab3
        System.out.println(1 + 2 + "c"); // 3c

        int three = 3;
        String four = "4";
        System.out.println(1 + 2 + three + four);

        // Getting Characters and Substrings by Index
        char firstChar = s1.charAt(0); // H
        System.out.println("First char: " + firstChar);
        String string = "animals";
        System.out.println(string.charAt(0)); // a
        System.out.println(string.charAt(6)); // s
        // System.out.println(string.charAt(7)); // throws
        // StringIndexOutOfBoundsException

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

        String v1 = "Java";
        String v2 = "Java";
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Ja").append("va");
        System.out.println(v1 == v2); // true
        System.out.println(v1.equals(v2)); // true
        System.out.println(sb1.toString() == v1); // false
        System.out.println(sb1.toString().equals(v1)); // true

        // lower-uppercase
        String str15 = "animals";
        System.out.println(str15.toUpperCase()); // ANIMALS
        // remember that strings are immutable, so the original string stays the same.
        System.out.println(str15); // animals
        str15 = str15.toUpperCase();
        System.out.println(str15); // ANIMALS

        System.out.println("Abc123".toLowerCase()); // abc123

        // slicing
        String mov = "StarWars";
        System.out.println(mov.substring(4)); // Wars
        System.out.println(mov.substring(0, 4)); // Star
        System.out.println(mov.substring(mov.indexOf('W'))); // Wars
        // System.out.println(mov.substring(4, 3)); // ERR
        // java.lang.StringIndexOutOfBoundsException

        // equals
        System.out.println("abc".equals("ABC")); // false
        System.out.println("ABC".equals("ABC")); // true
        System.out.println("abc".equalsIgnoreCase("ABC")); // true

        // prefix - suffix
        System.out.println("abc".startsWith("a")); // true
        System.out.println("abc".startsWith("A")); // false

        // contains: case-sensitive match
        System.out.println("abc".contains("b")); // true
        System.out.println("abc".contains("B")); // false

        // strip
        String text = " abc\t ";
        System.out.println("*****strip");
        System.out.println(text); // abc
        System.out.println(text.length()); // 6
        System.out.println(text.strip().length()); // 3
        System.out.println(text.stripLeading().length()); // 5
        System.out.println(text.stripTrailing().length()); // 4

        // formatting
        var customer = "Kate";
        var orderId = 5;
        var price = 15.1292;
        // All print: Hello Kate, order 5 is ready
        System.out.println("Hello " + customer + ", order " + orderId + " costs " + price); // Hello Kate, order 5 costs
                                                                                            // 15.1292
        String msg = String.format("Hello %s, order %d costs %.2f", customer, orderId, price);
        System.out.println(msg); // Hello Kate, order 5 costs 15.13

        // looping
        String alpha = "";
        for (char current = 'a'; current <= 'z'; current++)
            alpha += current;
        System.out.println(alpha); // abcdefghijklmnopqrstuvwxyz

        StringBuilder alpha2 = new StringBuilder(); // Efficient mutable String

        for (char current = 'a'; current <= 'z'; current++)
            alpha2.append(current); // Efficient O(1) append operation

        System.out.println(alpha.toString()); // Convert StringBuilder to String

        // Method chaining
        String result = " AniMaL ".trim().toLowerCase();
        System.out.println(result);

        // replace (ALL)
        System.out.println("mesquite in your cellar".replace('e', 'o')); // "mosquito in your collar"
        System.out.println("aAbBaA".replace('A', '.')); // "a.bBa."

        // There are three ways to construct a StringBuilder:
        StringBuilder sb01 = new StringBuilder();
        StringBuilder sb02 = new StringBuilder("animal");
        StringBuilder sb03 = new StringBuilder(10);

        sb01 = new StringBuilder("animals");
        sb01.insert(7, "-"); // sb = animals-
        sb01.insert(0, "$"); // sb = -animals-
        System.out.println(sb01);

        // delete
        sb01 = new StringBuilder("TR_123");
        sb01.delete(0, 3); // sb01 = 123
        System.out.println(sb01);

        // deleteCharAt
        sb01 = new StringBuilder("_TR");
        sb01.deleteCharAt(0); // TR
        System.out.println(sb01);
        // sb01.deleteCharAt(99); // ERR StringIndexOutOfBoundsException

        // reverse
        sb01 = new StringBuilder("ABC");
        sb01.reverse(); // "CBA"
        System.out.println(sb01);

        // toString
        String s = sb01.toString();
        System.out.println(s);

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
        int[] factorial;
        // factorial = { 1, 1, 2, 6, 24, 120, 720, 5040 }; // ERR Array constants can
        // only be used in initializers.
        factorial = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040 };

        // Iterate through the array using a for-each loop
        System.out.println("\nIterate using for-each loop:");
        for (int number : scores) {
            System.out.println(number);
        }

        // varargs
        int total1 = total();
        int total2 = total(1, 2, 3);
        int total3 = total(new int[] { 1, 2, 3 });
        System.out.println("total1: " + total1);
        System.out.println("total2: " + total2);
        System.out.println("total3: " + total3);

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

        int[][] vars1; // 2D array
        int vars2[][]; // 2D array
        int[] vars3[]; // 2D array
        int[] vars4[], space[][]; // a 2D AND a 3D array

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

        // sorting
        Util.header("Arrays.sort()");
        int[] nums = { 6, 9, 1 };
        Arrays.sort(nums); // [1, 6, 9]
        System.out.println(Arrays.toString(nums));

        Car car1 = new Car("Kia", "Sorento", 2007);
        Car car2 = new Car("Toyota", "Camry", 2015);
        Car car3 = new Car("Ford", "Mustang", 1967);

        Car[] cars = { car1, car2, car3 };

        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars); // sort in-place, according to .compareTo()

        System.out.println(Arrays.toString(cars));

        // Compare arrays
        Util.header("array equality");
        int[] scores1 = { 1, 2, 3, 4, 5 };
        int[] scores2 = { 1, 2, 3, 4, 5 };

        // The == operator compares references
        // scores1 and scores2 are two separate array objects
        System.out.println(scores1 == scores2); // false

        // The equals method on arrays does not compare array contents.
        // Instead, it inherits the equals method from Object, which also compares
        // references.
        System.out.println(scores1.equals(scores2)); // false

        // Correct way to compare contents
        System.out.println(Arrays.equals(scores1, scores2)); // true

        // binary search
        Util.header("Binary Search");
        int[] scores02 = { 40, 60, 70, 85, 95 };
        System.out.println(Arrays.binarySearch(scores02, 40)); // 0
        System.out.println(Arrays.binarySearch(scores02, 70)); // 2
        System.out.println(Arrays.binarySearch(scores02, 100)); // -(5+1)
        System.out.println(Arrays.binarySearch(scores02, 30)); // -(0+1)

        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 2, 0, 4, 5 };

        int mismatchIndex = Arrays.mismatch(arr1, arr2);
        System.out.println("First mismatch at index: " + mismatchIndex); // 2
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

        // int x = 1;
        // if (x=5) { // DOES NOT COMPILE Type mismatch: cannot convert from int to
        // boolean
        // System.out.println("x is true");
        // }

        int x1 = 50, x2 = 75;
        boolean b = x1 > x2;
        if (b = true)
            System.out.println("b=2 evaluates to true");
        else
            System.out.println("Failure");
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

    public void notGoodButValid() {
        String str = null;
        int x = str.length(); // Null pointer access!
        System.out.println("Length: " + x);
    }

    public void exceptionBasics() {

        notGoodButValid();

        try {

            System.out.println("try block begins");
            throw new RuntimeException("Thrown from try");

        } catch (RuntimeException e) {

            System.out.println("catch block begins");
            throw new RuntimeException("Thrown from catch");

        } finally {
            System.out.println("Finally executed.");
            throw new NullPointerException("Thrown from finally");
        }
    }

    public void loopBasics() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Count is: " + i);
        }

        // while (true) {
        // // Code to be executed repeatedly
        // System.out.println("This loop will run forever.");
        // }

        // Creating an Infinite Loop
        // for (; ; ) {
        // System.out.println("forever");
        // }

        System.out.println("*******");
        int j = 0;
        for (; j < 5; j++) {
            System.out.print("*");
        }
        System.out.println(j);
        System.out.println("*******");

        // int x = 0;
        // for (long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
        // System.out.print(y + " ");
        // }
        // System.out.print(x);

        // int x = 2;
        // int y = 5;
        // while (x < 10)
        // y++;

        int x = 0;
        do {
            x++;
        } while (false);
        System.out.println(x);

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

        // String names = "Lisa";
        // for (char c : names) { // DOES NOT COMPILE Can only iterate over an array or
        // an instance of java.lang.Iterable
        // System.out.print(c + " ");
        // }

        // optional labels
        String[][] names = { { "A", "B", "C" }, { "D", "E", "F", }, { "G", "H", "I" } };
        outerloop: for (String[] row : names) {
            for (String name : row) {
                System.out.println("Check: " + name);
                if (name.contains("D")) {
                    System.out.println("Found D!");
                    // break outerloop;
                    break; // breaks inner for loop
                }

            }
        }

    }

    public void enumBasics() {

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

        // Overloading
        OverloadTest ot = new OverloadTest();
        ot.overloadedOperation(1, "A");
        ot.overloadedOperation("A", 1);

        byte byteVal = 1;
        ot.f(byteVal); // short!

    }

    // Method with a varargs parameter
    public int addV(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
        return sum;
    }

    public void methodBasics() {
        Util.header("Method Basics");

        // Option 1: Passing individual elements (Java creates the array)
        int sum1 = addV(1, 2, 3, 4, 5);

        // Option 2: Passing an array
        int[] grades = { 1, 2, 3, 4, 5 };
        int sum2 = addV(grades);

    }

    public void genericsBasics() {
        System.out.println("Generics Basics");
        System.out.println("---------------");

        GenericBox<Integer> box = new GenericBox<>(0);
        System.out.println(box.getValue());

    }

    public void containerBasics() {
        ListDemo ld = new ListDemo();
        ld.listBasics();
    }

    public void stackBasics() {
        System.out.println("Stack Basics");
        System.out.println("------------");

        StackMK stack = new StackMK(2);
        System.out.println(stack);

        stack.push(50);
        stack.push(70);
        stack.push(90);

        System.out.println(stack);

        int val1 = stack.pop();
        System.out.println(stack);
        int val2 = stack.pop();
        System.out.println(stack);
        int val3 = stack.pop();

        System.out.println(stack);

        stack.push(100);
        System.out.println(stack);

    }

    public void inheritanceBasics() {
        System.out.println("Inheritance");
        System.out.println("-----------");

        Animal dog1 = new Dog("bark");
        Animal cat1 = new Cat("cat1");
        Animal cat2 = new Cat("cat2");

        System.out.println(Animal.getAnimalCount()); // 3

        Cat.incrementAnimalCount();

        System.out.println(Animal.getAnimalCount()); // 4
        System.out.println(Dog.getAnimalCount()); // 4
        System.out.println(Cat.getAnimalCount()); // 4

        // access a static field defined on the superclass
        System.out.println(Animal.MAX_AGE);
        System.out.println(Dog.MAX_AGE);
        System.out.println(Cat.MAX_AGE);
    }

    public void relationshipsBasics() {
        System.out.println("Relationships");
        System.out.println("-------------");

        // 1-1 relationship on both ends
        // Create a Country object
        Country usa = new Country("USA");
        // Create a President object associated with the country
        President potus = new President("Trump", usa);

        System.out.println(usa);
        System.out.println(potus);

        // check if country is notified
        System.out.println("Check if country is modified: " + usa.getPresident()); //

        President putin = new President("Putin");
        Country rus = new Country("Russia", putin);

        System.out.println(putin);
        System.out.println(rus);

        // Create instances of Student and Course
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        Course course1 = new Course("Math");
        Course course2 = new Course("Science");

        // Enroll students in courses
        student1.enrollInCourse(course1);

        // course2.register(student2);

        // check the result on student's side:
        // System.out.println(student1.getEnrolledCourses());
        // System.out.println(course1.getEnrolledStudents());

        // System.out.println(student2.getEnrolledCourses());
        // System.out.println(course2.getEnrolledStudents());
    }

    public void patternsBasics() {
        System.out.println("Patterns");
        System.out.println("--------");
        patterns.User user = patterns.User.builder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .build();
    }

    public void timeBasics() {
        Date today = new Date();
        System.out.println(today); // Output: Current date and time in milliseconds since epoch

        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdformat.format(today);
        System.out.println(formattedDate); // 2025-01-26

        TimeZone tz = TimeZone.getTimeZone("Europe/Istanbul");
        System.out.println("Timezone: " + tz.getDisplayName());

        Calendar calendar = new GregorianCalendar(tz);

        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH: " + calendar.get(Calendar.MONTH) + 1); // Months are 0-indexed
        System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));

        // java.time package
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(1999, 12, 31);

        System.out.println(date1); // 2025-01-26
        System.out.println(date2.getYear()); // 1999

        LocalDate tomorrow = date1.plusDays(6);

        System.out.println(tomorrow); // 2025-02-01

        // tring form of all available region-based IDs.
        Set<String> zones = ZoneId.getAvailableZoneIds();
        for (String zone : zones) {
            if (zone.contains("London"))
                System.out.println(zone);
        }

        ZonedDateTime zdate1 = ZonedDateTime.now(ZoneId.of("Europe/Istanbul"));
        System.out.println(zdate1); // 2025-01-27T01:52:56.243788+03:00[Europe/Istanbul]

        Instant timestamp1 = Instant.now();
        System.out.println(timestamp1); // 2025-01-26T23:05:20.940715Z

        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT; // Use ISO_INSTANT for standard format
        String timestamp1STR = formatter.format(timestamp1); // 2025-01-26T23:13:47.745515Z
        System.out.println(timestamp1STR);

        // Duration
        Duration oneHour = Duration.ofHours(1);
        Duration thirtyMinutes = Duration.ofMinutes(30);
        Duration twoDays = Duration.ofDays(2);

        System.out.println(oneHour); // PT1H
        System.out.println(thirtyMinutes); // PT30M
        System.out.println(twoDays); // PT48H

        Duration totalDuration = oneHour.plus(thirtyMinutes);
        System.out.println("Total Duration: " + totalDuration); // PT1H30M

        Duration difference = oneHour.minus(thirtyMinutes);
        System.out.println("Difference: " + difference); // PT30M

        // Period
        Period period30Days = Period.ofDays(30);
        System.out.println(period30Days); // P30D

        Period period1 = date2.until(date1);
        System.out.println(period1); // P25Y26D
        System.out.println(period1.getYears()); // 25
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
        System.out.println("total(): varargs only.");
        if (nums.length == 0)
            return 0;

        int sum = 0;

        // vararg is treated as an array of the specified data type.
        for (int n : nums) {
            sum += n;
        }

        return sum;
    }

    // public int total(int first, int... others) {
    // System.out.println("total(): 2 parameters");
    // int sum = first;

    // // vararg is treated as an array of the specified data type.
    // for (int n : others) {
    // sum += n;
    // }

    // return sum;
    // }

    public void stringEquality(String s1, String s2) {

        System.out.printf("Comparing strings %s vs %s\n", s1, s2);

        if (s1 == s2) {
            System.out.printf("%s == %s\n", s1, s2);
        } else {
            System.out.printf("%s != %s\n", s1, s2);
        }

        if (s1.equals(s2)) {
            System.out.printf("%s.equals(%s)\n", s1, s2);
        } else {
            System.out.printf("!%s .equals(%s)\n", s1, s2);
        }
    }
}
