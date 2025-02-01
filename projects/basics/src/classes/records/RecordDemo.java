package classes.records;

import clone.Person;

public class RecordDemo {

    public static void main(String[] args) {

        PersonRecord p1 = new PersonRecord("Alice", 30);
        System.out.println(p1.name()); // Alice
        System.out.println(p1.age()); // 30

        PersonRecord p2 = new PersonRecord("Alice", 30);

        System.out.println(p1 == p2); // false
        System.out.println(p1.equals(p2)); // true
        System.out.println(p1.hashCode() == p2.hashCode()); // true
        System.out.println(p1); // PersonRecord[name=Alice, age=30]

    }
}
