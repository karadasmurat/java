package enums;

public class EnumDemo {

    public static void main(String[] args) {

        Appointment appointment = new Appointment(DayOfWeek.MON);

        Size size = Size.LARGE;

        for (Size s : Size.values()) {
            System.out.println(s);
        }

    }
}
