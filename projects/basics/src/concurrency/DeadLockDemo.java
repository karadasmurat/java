package concurrency;

import java.util.concurrent.Executors;

class Food {
}

class Water {
}

class Fox {

    private String name;

    public Fox(String name) {
        this.name = name;
    }

    public void eatAndDrink(Food food, Water water) {
        synchronized (food) {
            System.out.println(name + " Got Food!");
            crossTheBridge();
            synchronized (water) {
                System.out.println(name + " Got Water!");
            }
        }
    }

    public void drinkAndEat(Food food, Water water) {
        synchronized (water) {
            System.out.println(name + " Got Water!");
            crossTheBridge();
            synchronized (food) {
                System.out.println(name + " Got Food!");
            }
        }
    }

    public void crossTheBridge() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

}

public class DeadLockDemo {
    public static void main(String[] args) {
        // Create participants and resources
        var foxy = new Fox("Foxy");
        var tails = new Fox("Tails");
        var food = new Food();
        var water = new Water();

        // Process data
        try (var service = Executors.newScheduledThreadPool(10)) {
            service.submit(() -> foxy.eatAndDrink(food, water));
            service.submit(() -> tails.drinkAndEat(food, water));
        }
    }
}

