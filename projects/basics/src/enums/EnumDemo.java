package enums;

public class EnumDemo {

    String getWeather(Season value) {
        return switch (value) {
            case SUMMER -> "Too hot";
            case Season.WINTER -> "Too cold";
            case SPRING, FALL -> "Just right";
        };
    }

    public static void main(String[] args) {

        EnumDemo demo = new EnumDemo();
        Season sn = Season.SUMMER;
        System.out.println(sn); // SUMMER
        System.out.println(sn == Season.SUMMER); // true

        System.out.println(demo.getWeather(Season.SPRING)); // Just right

        Appointment appointment = new Appointment(DayOfWeek.MON);

        Size size = Size.LARGE;

        for (Size s : Size.values()) {
            System.out.println(s);
        }

        for (Season season : Season.values()) {
            System.out.println(season.name() + " " + season.ordinal());
        }

        // call an enum instance method
        DayOfWeek day = DayOfWeek.FRI;
        if (day.isWeekend()) {
            System.out.println("Have a good weekend!");
        } else {
            System.out.println("Work, work, work!");
        }
        ;

    }
}
