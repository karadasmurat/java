package domain.records;

public class RecordDemo {

    public static void main(String[] args) {
        EmployeeRecord employee = new EmployeeRecord(1, "Alice");
        System.out.println(employee); // EmployeeRecord[id=1, name=Alice]
        System.out.println(employee.nameInUppercase());
    }
}
