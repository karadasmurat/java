package domain.records;

public record EmployeeRecord(int id, String name) {

    public EmployeeRecord {
        if (id < 0) {
            throw new IllegalArgumentException("id cannot be negative.");
        }
    }

    public String nameInUppercase() {
        return name.toUpperCase();
    }
}
