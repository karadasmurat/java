package format;

import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class FormatDemo {

    public static void printWelcomeMessage(Locale locale) {
        var rb = ResourceBundle.getBundle("app", locale);
        System.out.println(rb.getString("hello")
                + ", " + rb.getString("open"));
    }

    public static void main(String[] args) {

        NumberFormat shortFormat = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        NumberFormat longFormat = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);

        System.out.println(shortFormat.format(999)); // ✅ Output: 999

        System.out.println(shortFormat.format(1000)); // ✅ Output: 1K
        System.out.println(shortFormat.format(1499)); // ✅ Output: 1K
        System.out.println(shortFormat.format(1500)); // ✅ Output: 2K
        
        System.out.println(shortFormat.format(10_000)); // ✅ Output: 10K
        System.out.println(shortFormat.format(2500001)); // ✅ Output: 3M
        System.out.println(longFormat.format(1000)); // ✅ Output: 1 thousand
        System.out.println(longFormat.format(2500001)); // ✅ Output: 3 million

    }

}
