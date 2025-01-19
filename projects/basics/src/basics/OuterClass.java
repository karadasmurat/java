package basics;
public class OuterClass {

    private String outerField = "Outer field";
    private static String staticOuterField = "Static outer field";

    class InnerClass {

        void accessMembersOfOuter() {
            System.out.println(outerField); // OK Has direct access all members of outer class
            System.out.println(staticOuterField); // OK Has direct access all members of outer class
        }
    }
}
