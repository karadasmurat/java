package format;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class FormatDemo {

    public static void printWelcomeMessage(Locale locale) {
        var rb = ResourceBundle.getBundle("app", locale);
        System.out.println(rb.getString("hello")
                + ", " + rb.getString("open"));
    }

    public static void main(String[] args) {
        var tur = Locale.of("tr", "TR");

        var rb = ResourceBundle.getBundle("app", Locale.of("tr", "TR"));
        System.out.println(rb.getString("hello")); // Merhaba

        String price_en = "40.45"; // dot is part of the number
        String price_tr = "40,45"; // comma is part of the number
        var nf_en = NumberFormat.getInstance(Locale.US);
        var nf_tr = NumberFormat.getInstance(Locale.of("tr", "TR"));
        try {
            var number_en = nf_en.parse(price_en);
            var number_tr = nf_tr.parse(price_tr);
            System.out.println("Parsed number (en): " + number_en); // 40.45
            System.out.println("Parsed number (tr): " + number_tr); // 40.45
        } catch (Exception e) {
            System.out.println("Failed to parse price_en: " + e);
        }
    }

}
