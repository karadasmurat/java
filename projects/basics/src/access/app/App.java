package access.app;

import access.one.KeeperOfProtectedMethod;

public class App {

    public static void main(String[] args) {

        KeeperOfProtectedMethod keeper = new KeeperOfProtectedMethod();
        // keeper.protectedMethod(); // CompileERR Not visible

        // From the perspective of the App class, api is an instance of ApiBase
        // The App class does not have access to the protected members of ApiBase
        // because it's in a different package
        // ApiBase api = new ExtendedAPI(); // valid due to polymorphism
        // api.protectedMethodAPI(); // ❌ The method from the type ApiBase is not
        // visible

        // Animal animal = new MarsianAnimal();
        // animal.publicMethodAnimal();
        // animal.protectedMethodAnimal(); // ❌ The protected method form the type
        // Animal is not visible

    }

}
