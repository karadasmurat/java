package classes.abstracts;

public class HRSystem {
    public static void main(String[] args) {

        // Employee genericEmployee = new Employee("Alice", 101); // ERR Cannot
        // instantiate the type Employee

        // reference type: Employee, object type: FullTimeEmployee: dynamic dispatch!
        Employee fullTimeEmp = new FullTimeEmployee("Alice", 101, 5000);
        fullTimeEmp.displayEmployeeDetails();
        System.out.println("Salary: $" + fullTimeEmp.calculateSalary());

        Employee contractEmp = new ContractEmployee("Bob", 102, 50, 120);
        contractEmp.displayEmployeeDetails();
        System.out.println("Salary: $" + contractEmp.calculateSalary());
    }
}


