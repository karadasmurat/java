package clone;


// Person implicitly extends Object and therefore inherits the Object.clone() method
// clone is defined as protected in the Object, therefore inherited as protected.
// It'saccessible within the Person class but not directly from outside.
// It will not be directly accessible from outside the Person class or its subclasses.
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void doSomething() throws CloneNotSupportedException{
        clone(); // Person inherits protected clone, can use it internally
    }

}
