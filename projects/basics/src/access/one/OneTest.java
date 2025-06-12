package access.one;

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
    }

}
