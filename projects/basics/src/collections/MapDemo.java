package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapDemo implements CollectionsDemo {

    @Override
    public void declareAndInitialize() {

        Map<String, Integer> map = new HashMap<>();

        // Adding elements
        map.put("Harry", 80);
        map.put("Ron", 70);
        map.put("Hermione", 90);

        // Accessing elements
        System.out.println("Harry's score: " + map.get("Harry"));

        // Accessing keys that do not exist
        System.out.println("Draco's score: " + map.get("Draco")); // null
        System.out.println("Draco's score: " + map.getOrDefault("Draco", 0)); // 0

    }

    @Override
    public void accessElements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accessElements'");
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
