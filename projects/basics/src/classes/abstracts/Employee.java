package classes.abstracts;

// Abstract class defining common properties and behavior
abstract class Employee {
    protected String name;
    protected int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Concrete method - Common for all employees
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + id + ", Name: " + name);
    }

    // Abstract method - Must be implemented by subclasses
    abstract double calculateSalary();
}
