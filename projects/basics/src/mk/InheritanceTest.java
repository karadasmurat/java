package mk;

import inheritance.sub.Child1;

public class InheritanceTest {
    public static void main(String[] args) {
        Child1 child1 = new Child1();

        System.out.println(child1.publicField);

        // protected field accessible through a public getter
        child1.accessParentFields(); 

        
        System.out.println(child1.protectedField); // ERR The field Parent.protectedField is not visible
    }
}
