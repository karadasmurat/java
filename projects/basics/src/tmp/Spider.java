package tmp;

// The three process methods have distinct parameter lists:
class Parent {

    public void process(String s) {
        System.out.println("String processor: " + s);
    }

    public void process(int i) {
        System.out.println("int processor: " + i);
    }

    public boolean process() {
        System.out.println("branching processor. ");
        return true;
    }
}