package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo implements CollectionsDemo {

    @Override
    public void declareAndInitialize() {

        Map<String, Integer> map = new HashMap<>();

        // Adding elements
        map.put("Harry", 66);
        map.put("Harry", 80); // overwrites the previous value!
        map.put("Ron", 70);
        map.put("Hermione", 90);
        map.putIfAbsent("Hermione", 99); // does not overwrite the previous value!

        // Accessing elements
        System.out.println("Harry's score: " + map.get("Harry")); // Harry's score: 80
        // get() returns null if the key does not exist
        System.out.println("MK's score: " + map.get("MK")); // MK's score: null

        // Accessing keys that do not exist
        System.out.println("Draco's score: " + map.get("Draco")); // null

        // getOrDefault() returns a defaultValue if this map contains no mapping for the
        // key.
        System.out.println("Draco's score: " + map.getOrDefault("Draco", 0)); // 0

        // The lambda has both the key and value as the parameters
        map.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("keySet():");
        map.keySet().forEach(System.out::println);

        System.out.println("values():");
        map.values().forEach(System.out::println);

        // Iterating over keys
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }

        // Iterating over entries
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // Factory methods
        Map<String, Integer> map2 = Map.of("Harry", 80, "Ron", 70, "Hermione", 90);

        var map3 = Map.ofEntries(
                Map.entry("Harry", 80),
                Map.entry("Ron", 70),
                Map.entry("Hermione", 90));

        // in-place modification of all values
        // increase prices by 10%
        Map<String, Double> prices = new HashMap<>();
        prices.put("Apple", 1.0);
        prices.put("Banana", 0.5);
        prices.put("Orange", 0.8);

        prices.replaceAll((product, price) -> price * 1.10);
        System.out.println(prices);

        // TreeMap
        TreeMap<Integer, String> students = new TreeMap<>();
        students.put(105, "Alice");
        students.put(101, "Bob");
        students.put(103, "Charlie");

        System.out.println(students); // {101=Bob, 103=Charlie, 105=Alice}

        System.out.println(students.floorKey(105)); // 105
        System.out.println(students.floorEntry(105)); // 105=Alice

        System.out.println(students.subMap(101, 104)); // {101=Bob, 103=Charlie}

        var members = List.of("Harry", "Ron", "Hermione", "Harry", "Ron", "Harry");
        var frequencies = new HashMap<String, Integer>();
        for (String member : members) {
            int val = frequencies.getOrDefault(member, 0);
            frequencies.put(member, val + 1);
        }

        System.out.println(frequencies); // {Ron=2, Harry=3, Hermione=1}

    }

    @Override
    public void accessElements() {
        // TODO Auto-generated method stub

    }

    @Override
    public void iterate(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterate'");
    }

    public static void main(String[] args) {
        MapDemo demo = new MapDemo();
        demo.declareAndInitialize();
    }

}

