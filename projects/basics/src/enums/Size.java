package enums;

// Adding a constructor and a final field
public enum Size {

    SMALL("S"), MEDIUM("M"), LARGE("L"); // fixed set of instances

    // Enums can have fields to store additional information relevant to each
    // constant.
    private final String label;

    // Enums are essentially classes with a fixed set of instances.
    // enum doesn’t support the creation of objects: it's illegal to use new
    // operator for an enum
    // However, the constructor is invoked implicitly during enum class loading to
    // initialize fields for each constant.
    Size(String label) {
        this.label = label;
    }

}
