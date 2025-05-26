package access.one;

public class OneTest {

    public static void main(String[] args) {

        // OneTest is a class in the same package as A
        A a = new A();

        C c = new C(); // C is package-private, can be accessed by package friends

        // Call public method
        a.publicMethodA(); // OK

        // Call protected method
        a.protectedMethodA(); // OK

        // Call package-private method
        a.packagePrivateMethodA(); // OK

        // Call private method - this will NOT work, as private methods are not
        // accessible outside the class
        // a.privateMethodA(); // ❌ CompileERR: not visible
    }

}
