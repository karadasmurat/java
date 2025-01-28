// 
/*
 * in a different package from its parent
 * the subclass cannot access the protected members of the parent class 
 * through an instance of the parent class if they are in different packages. 
 * However, the subclass can access the protected members through inheritance, 
 * meaning it can directly access them within its own methods.
 * 
 * Protected members are accessible outside the package only to subclasses, 
 * but only through inheritance, not through an instance of the parent.
 */

package access.pond.goose;

import access.pond.Bird;

public class Goose extends Bird {

    public Goose(String name) {
        super(name);
    }

    // ❌ Cannot access protected members via an instance
    void accessParentsProtectedFieldThroughParent() {
        Bird bird = new Bird("Bird1");
        // System.out.println(bird.name); // ERR The field Bird.name is not visible!
        // bird.floatInWater(); The method floatInWater() from the type Bird is not
        // visible!
    }

    // Protected members are accessible outside the package only to subclasses,
    // but only through inheritance, not through an instance of the parent.
    // ✅ Can access protected members through inheritance (directly)
    void accessParentsProtectedFieldThroughSelf() {
        System.out.println(name);
        floatInWater();
    }
}
