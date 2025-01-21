package mk;

public class Parcel {

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    // Using inner classes looks just like
    // using any other class, within Parcel:
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {

        Parcel p = new Parcel();

        p.ship("Tasmania");
        Parcel q = new Parcel();

        // Defining references to inner classes:
        // specify the type of that object as OuterClassName.InnerClassName
        // Parcel.Contents c = q.contents();
        Parcel.Contents c = q.new Contents();

        // Parcel.Destination d = q.to("Borneo");
        Parcel.Destination d = q.new Destination("Borneo");
    }
}