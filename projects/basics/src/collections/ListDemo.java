package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import util.Util;

public class ListDemo {

    void equality() {
        Util.header("Equality");

        // Two separate ArrayList objects, one and two, are created.
        // Both are empty at this point.
        List<String> one = new ArrayList<>();
        List<String> two = new ArrayList<>();

        // List.equals() method in Java compares two lists for content equality.
        // * If both lists have the same size.
        // * If corresponding elements in both lists are equal.
        // Since both one and two are empty, they are considered equal.
        System.out.println(one.equals(two)); // true

        one.add("a"); // [a]
        System.out.println(one.equals(two)); // false

        two.add("a"); // [a]
        System.out.println(one.equals(two)); // true

        one.add(new String("x")); // [a, x]
        two.add(new String("x")); // [a, x]
        System.out.println(one.equals(two)); // true

        one.add("b"); // [a, x, b]
        two.add(0, "b"); // [b, a, x]
        System.out.println(two);

        System.out.println(one.equals(two)); // false
    }

    void sorting() {
        
        List<Integer> numbers = new ArrayList<>();

        numbers.add(99);
        numbers.add(5);
        numbers.add(81);

        Collections.sort(numbers); // [5, 81, 99]

        System.out.println(numbers);
    }

    void conversionBtwListandArray() {

        List<String> list = new ArrayList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");

        // List to array
        Object[] arr = list.toArray();

        for (Object element : arr) {
            System.out.println(element);
        }

        Integer[] nums = { 1, 2, 3, 4, 5 };
        List<Integer> numlist = Arrays.asList(nums);
    }

    public void listBasics() {
        System.out.println("List Basics");
        System.out.println("-----------");

        // Declare and initialize
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>(10);
        ArrayList<Integer> list3 = new ArrayList<>(list2);

        List<Integer> list4 = new ArrayList<>(); // ArrayList is a List
        // ArrayList<String> list7 = new List<>(); // DOES NOT COMPILE Type mismatch:
        // cannot convert from List to ArrayList<>

        List<String> names = new ArrayList<>();

        // check if the collection contains elements
        if (names.isEmpty()) {
            System.out.println("Collection contains no elements.");
        }

        // remove
        Util.header("remove");
        List<String> birds = new ArrayList<>();
        birds.add("hawk"); // [hawk]
        birds.add("hawk"); // [hawk, hawk]
        System.out.println(birds.remove("cardinal")); // prints false
        System.out.println(birds.remove("hawk")); // prints true
        System.out.println(birds.remove(0)); // prints hawk
        System.out.println(birds); // []

        // add elements to the list
        names.add("Ron");
        names.add("Harry");
        names.add("Ron"); // Duplicates are allowed in List

        // set
        Util.header("set");
        List<String> birds2 = new ArrayList<>();
        birds2.add("hawk"); // [hawk]
        System.out.println(birds2.size()); // 1
        birds2.set(0, "robin"); // [robin]
        System.out.println(birds2.size()); // 1
        System.out.println(birds2); // [robin]

        // clear
        Util.header("clear()");
        List<String> birds3 = new ArrayList<>();
        birds3.add("hawk"); // [hawk]
        birds3.add("hawk"); // [hawk, hawk]
        System.out.println(birds3.isEmpty()); // false
        System.out.println(birds3.size()); // 2
        birds3.clear(); // []
        System.out.println(birds3.isEmpty()); // true
        System.out.println(birds3.size()); // 0

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

        // equality();
        // conversionBtwListandArray();
        sorting();
    }

    public static void main(String[] args) {
        ListDemo ld = new ListDemo();
        ld.listBasics();

    }
}
