package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import clone.Person;
import domain.Product;
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

    public void declareAndInitialize() {

        // Declare and initialize
        ArrayList<Integer> list1 = new ArrayList<>();

        var list6 = new ArrayList<Integer>(); // var: ArrayList<Integer>

        ArrayList<Integer> list2 = new ArrayList<>(100);
        list2.add(1);
        list2.add(2);
        System.out.println(list2.size());
        list2.trimToSize(); // Trims the capacity of this ArrayList instance to be the list's current size.

        ArrayList<Integer> list3 = new ArrayList<>(list2);

        List<Integer> list4 = new ArrayList<>(); // List reference pointing to ArrayList object
        // ArrayList<String> list7 = new List<>(); // DOES NOT COMPILE Type mismatch:
        // cannot convert from List to ArrayList<>

        var list9 = List.of(40, 50, 60); // var: List<Integer>

        Integer[] scores = { 50, 70, 90 };
        var list10 = List.of(50, 60, 70);
        // list10.set(0, 100); // immutable! UnsupportedOperationException

        var list11 = List.of(scores);

        var list12 = Arrays.asList(scores);

        System.out.println("List from an array using .of() with varargs");
        System.out.println(list10.size());
        list10.forEach(System.out::println);

        List<String> birds = new ArrayList<>();
        birds.add("hawk"); // [hawk]
        birds.add("hawk"); // [hawk, hawk]
        birds.add(1, "owl"); // [hawk, owl, hawk]
        birds.addFirst("firstBird");// [firstBird, hawk, owl, hawk]
        birds.addLast("lastBird");// [firstBird, hawk, owl, hawk, lastBird]
        System.out.println(birds);

        birds.remove("hawk"); // [firstBird, owl, hawk, lastBird]
        birds.remove(0); // [owl, hawk, lastBird]
        birds.removeFirst(); // [hawk, lastBird]
        System.out.println(birds);

        // Creating a list with Factory
        List<String> ofList = List.of("one", "two", "three");

        // ofList.add("err"); // UnsupportedOperationException
        // ofList.remove("one"); // UnsupportedOperationException
        // ofList.set(0, "new"); // UnsupportedOperationException

        // v2 returns fixed size list backed by an array
        var asList = Arrays.asList("one", "two", "three");
        // asList.add("err"); // UnsupportedOperationException
        // asList.remove("one"); // UnsupportedOperationException
        asList.set(0, "UPDATED"); // OK [UPDATED, two, three]

        var numbers = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
        numbers.replaceAll(x -> x * 2); // [2.2, 4.4, 6.6, 8.8, 11.0]

        numbers.replaceAll(Math::ceil); // [3.0, 5.0, 7.0, 9.0, 11.0]
        System.out.println(numbers); 

    }

    public void remove() {
        Util.header("remove()");
        // Overloaded remove() methods: remove(int index) vs remove(Object o)

        var list = new LinkedList<Integer>();
        list.add(3);
        list.add(2);
        list.add(1);

        Integer removedElement1 = list.remove(2); // primitive argument: index
        System.out.println(removedElement1);

        boolean result = list.remove(Integer.valueOf(2));// Integer argument: element
        System.out.println(result);

        System.out.println(list);
    }

    public void listBasics() {
        Util.header("List Basics");

        declareAndInitialize();
        remove();

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

    public void shallowCopy() {

        Product product1 = new Product('A', 11);
        Product product2 = new Product('B', 12);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        // Creating a shallow copy
        List<Product> productsCopy = new ArrayList<>(products);

        // Modifying an element in the original list
        products.get(0).setStock(22);

        // Modify the stock of the second product
        product2.setStock(33);

        // Checking changes in both lists
        System.out.println(products); // [Product(code:A, stock:22), Product(code:B, stock:33)]
        System.out.println(productsCopy); // [Product(code:A, stock:22), Product(code:B, stock:33)]
    }

    public void iterate() {
        var numbers = List.of(1, 2, 3, 4, 5);

        // Using for-each loop
        for (var num : numbers) {
            System.out.println(num);
        }

        // Using an iterator
        Iterator<Integer> iter = numbers.iterator();
        while (iter.hasNext()) {
            Integer num = iter.next();
            System.out.println(num);
        }

    }

    public static void main(String[] args) {
        ListDemo ld = new ListDemo();
        // ld.listBasics();
        // ld.shallowCopy();
        ld.declareAndInitialize();
        // ld.remove();

    }
}
