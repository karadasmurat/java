package inheritance.sub;

import inheritance.Parent;

public class Child1 extends Parent {

    public void getAProtectedFieldInheritedFromParent() {
        // check if it "inherits": use it like a local field
        System.out.println(publicField);
        System.out.println(protectedField);

        // System.out.println(privateField); // ERR The field Parent.privateField is not
        // visible
    }

}
