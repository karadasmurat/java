package util;

import inheritance.animals.Animal;

public class Util {

    public static void header(String title) {
        System.out.println("****** " + title + " ******");
    }

    public static String getGreeting() {
        return "Hi!";
    }

    // Function, mapping Animal to String
    public static String getAgeCategoryOfAnimal(Animal animal) {

        return animal.getAge() < 1 ? "BABY" : "ADULT";

    }
}
