import java.util.Arrays;
import java.util.Comparator;

class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters for name and age
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // ... (toString() method for better output) ...
}

public class EmployeeSortExample {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Alice", 30),
                new Employee("Bob", 25),
                new Employee("Charlie", 35)
        };

        // Sort employees by age in ascending order using a Comparator
        Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        // Print sorted employees
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - " + employee.getAge());
        }
    }
}