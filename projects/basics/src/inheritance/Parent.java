package inheritance;

public class Parent {

    public String publicField = "Public Value";

    // protected access allows access to members within the same package and by
    // subclasses in any package.
    protected String protectedField = "Protected Value";

    private String privateField = "Private Value";
}
