package access.one;

import access.two.SpecialA2;

public class OneTest {

    public static void main(String[] args) {

        // OneTest is a class in the same package as A
        A a = new A();

        C c = new C(); // C is package-private, can be accessed by package friends

        // Call public method
        a.publicMethodA(); // ✅ visible. package friends see all, except private

        // Call protected method
        a.protectedMethodA(); // ✅ visible. package friends see all, except private

        // Call package-private method
        a.packagePrivateMethodA(); // ✅ visible. package friends see all, except private

        // Call private method - this will NOT work, as private methods are not
        // accessible outside the class
        // a.privateMethodA(); // ❌ CompileERR: not visible

        SpecialA1 sa1 = new SpecialA1();
        sa1.publicMethodA();
        sa1.protectedMethodA();
        sa1.packagePrivateMethodA();
        // sa1.privateMethodA();// ❌ CompileERR: not visible

        SpecialA2 sa2 = new SpecialA2();
        sa2.publicMethodA();
        sa2.protectedMethodA();
        // sa2.packagePrivateMethodA();
        // sa2.privateMethodA();
    }

}
