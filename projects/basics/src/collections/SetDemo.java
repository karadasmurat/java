package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import util.Util;

public class SetDemo implements CollectionsDemo {

    @Override
    public void declareAndInitialize() {
        Util.header("Declare and Initialize Sets.");

        Set<String> set0 = new HashSet<>();

        // create an immutable Set in one line
        var letters = Set.of('a', 'b', 'c'); // var: Set<Character>

        Set<Character> lettersCopy = Set.copyOf(letters);

        Set<String> members = new HashSet<>(); // Set reference pointing to HashSet object

        var set1 = new HashSet<Integer>(); // var: HashSet<Integer>

        // Note: List.of() creates a completely unmodifiable list. 
        // You cannot change, add, or remove elements.
        var list = List.of("Harry", "Ron", "Hermione", "Harry");
        list.add("Hagrid"); // UnsupportedOperationException

        // Creates a mutable set from the list
        Set<String> hogwarts = new HashSet<>(list);
        hogwarts.add("Draco");

    }

    @Override
    public void accessElements() {
        Util.header("Access Elements");

        HashSet<String> set1 = new HashSet<>();
        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        TreeSet<String> set3 = new TreeSet<>();

        // add
        // add method Adds the specified element to this set if it is not already
        // present. If this set already contains the element, the call leaves the set
        // unchanged and returns false.
        boolean b1 = set1.add("Harry"); // true
        boolean b2 = set1.add("Harry"); // false
        set1.add("Ron");
        set1.add("Hermione");

        if (!set1.add("Harry")) {
            System.out.println("Element already in the set.");
        }

        // hogwarts.add(1); //ERR add(String) is not applicable for int.
        set1.add(String.valueOf(1));

        iterate(set1); // [ Ron, 1, Harry, Hermione, ]

        set2.add("Harry"); // true
        set2.add("Harry"); // false
        set2.add("Ron");
        set2.add("Hermione");
        set2.add(String.valueOf(1));

        // LinkedHashSet, the code prints the elements in the order they were inserted.
        iterate(set2); // [ Harry, Ron, Hermione, 1, ]

        set3.add("Harry"); // true
        set3.add("Harry"); // false
        set3.add("Ron");
        set3.add("Hermione");
        set3.add(String.valueOf(1));

        // TreeSet, the code prints the elements in their natural sorted order!
        iterate(set3); // [ 1, Harry, Hermione, Ron, ]

        // remove() Removes the specified element from this set if it is present.
        // Returns true if this set contained the element (or equivalently, if this set
        // changed as a result of the call).
        set1.remove("Harry");

        iterate(set1); // [ Ron, 1, Hermione, ]

        // try to remove an element that is not in the set:
        if (!set1.remove("Harry")) {
            System.out.println("Remove failed. The set does not contain the specified element");
        }

        // get

        // set

    }

    @Override
    public void iterate(Collection set) {

        System.out.print("[ ");
        for (var element : set) {
            System.out.print(element + ", ");
        }
        System.out.println("]");

    }



    public static void main(String[] args) {
        SetDemo demo = new SetDemo();
        demo.declareAndInitialize();
        // demo.accessElements();
    }

}