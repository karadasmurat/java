package classes.records;

public record PersonRecord(String name, int age) {

    public PersonRecord {
        if (age < 0)
            throw new IllegalArgumentException("age cannot be negative");

        name = name.trim(); // Trim whitespace from parameter

        // this.name = name; // Illegal explicit assignment
        // this.age = age;   // Illegal explicit assignment
    }
}

