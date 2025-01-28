package access.pond;

public class Bird {

    protected String name;// protected access

    public Bird(String name) {
        this.name = name;
    }

    protected void floatInWater() { // protected access
        System.out.println("Bird floating..");
    }

}
