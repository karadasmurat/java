package access.app;

public class MarsianAnimal extends inheritance.animals.Animal {

    public void beamUp() {
        System.out.println("Beam me up, Scotty!");
    }

    public void accessTest() {
        protectedMethodAnimal(); // ✅ Protected method of parent - inherited
                                 // can be accessed directly as if it was declared in Fish itself.
    }

}
