package exceptions;

public class ExceptionDemo1 {

    public String nestedBlocks() {
        String result = "";
        String v = null;
        try {
            try {
                result += "before";
                v.length();
                result += "after";
            } catch (NullPointerException e) {
                result += "catch";
                throw new RuntimeException();
            } finally {
                result += "finally";
                throw new Exception();
            }
        } catch (Exception e) {
            result += "done";
        }
        return result;
    }

    public void cleanMethod() {

    }

    public void unreachableCatch() {

        // try {
        // cleanMethod();
        // } catch (MKException e) {
        // System.out.println("Exception!");
        // }
    }

    public static void main(String[] args) throws Exception {

        // try {
        // throw new RuntimeException("Thrown from try");
        // } catch (RuntimeException e) {
        // throw new RuntimeException("Thrown from catch");
        // } finally {
        // System.out.println("Finally executed.");
        // throw new Exception("Thrown from finally");
        // }

        ExceptionDemo1 ed = new ExceptionDemo1();
        String res = ed.nestedBlocks();
        System.out.println(res);

        ed.unreachableCatch();
    }
}
