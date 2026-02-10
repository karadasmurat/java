package access.a;

import access.b.Child;

public class ThirdParty {

    public static void main(String[] args) {

        Parent p = new Parent();
        p.protectedMethod(); // ✅ ThirdParty is in the same package as Parent

        Child c = new Child();
        c.protectedMethod(); // ✅
    }
}
