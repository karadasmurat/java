package access.two;

import access.one.A;

public class TwoTest {

    public static void main(String[] args) {

        // access.one.C c = new access.one.C(); // ❌ CompileERR: access.one.C is not
        // visible

        A a = new A();

        // Call public method
        a.publicMethodA(); // OK

        // Call protected method
        // a.protectedMethodA(); // ❌ CompileERR: Not visible

        // Call package-private method
        // a.packagePrivateMethodA(); // ❌ CompileERR: Not visible

        // Call private method - this will NOT work, as private methods are not
        // accessible outside the class
        // a.privateMethodA(); // ❌ CompileERR: Not visible

        SpecialA2 sa2 = new SpecialA2();
        sa2.publicMethodA(); // OK
        // sa2.protectedMethodA(); // ❌ CompileERR: Not visible
        // sa2.packagePrivateMethodA(); // ❌ CompileERR: Not visible
        // sa2.privateMethodA(); // ❌ CompileERR: Not visible
    }

}
