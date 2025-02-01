package enums;

public enum DayOfWeek {
    MON, TUE, WED, THU, FRI, SAT, SUN;

    public static final String DESCRIPTION = "DayOfWeek enum";

    // Method to check if it's a weekend
    public boolean isWeekend() {
        return this == SAT || this == SUN;
    }
}
