package mk;

class Contact {
    private String country;

    public Contact(String country) {
        this.country = country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Contact(" + this.country + ")";
    }

}

class Person implements Cloneable {
    private String name;
    private Contact contact;

    public Person(String name, Contact contact) {
        this.name = name;
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person(" + this.name + ", " + this.contact + ")";
    }
}

public class CloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Contact c1 = new Contact("TR");
        Person p1 = new Person("MK", c1);

        Person p2 = (Person) p1.clone();

        System.out.println(p1);
        System.out.println(p2);

        assert p1 != p2;

        if (p1 != p2) {
            System.out.println("Different objects!");
        } else {
            System.out.println("Same objects!");
        }

        // check if shallow copy, through reference field
        p1.getContact().setCountry("UK");
        System.out.println(p1);
        System.out.println(p2);

    }
}
