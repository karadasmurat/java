package coreapi.format;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import util.Util;

public class FormatDemo {

    public void formatStrings() {
        String name = "Alice";
        int age = 30;
        double price = 19.99;

        String formattedString = String.format("Name: %s, Age: %d, Price: %.2f", name, age, price);
        System.out.println(formattedString); // Output: Name: Alice, Age: 30, Price: 19.99

        String paddedString = String.format("|%10s|", name); // Padded to 10 characters
        System.out.println(paddedString); // Output: | Alice|
    }

    public void formatNumbers() {

        int i1 = 1234;
        double d0 = 1234.0;
        double d4 = 1234.5678;

        NumberFormat nf = NumberFormat.getInstance();

        String formatted = nf.format(d0);
        System.out.println(d0 + " -> " + formatted); // 1234.5678 -> 1,234.568

        // DecimalFormat df = new DecimalFormat("###,###.00");
        DecimalFormat df = new DecimalFormat("000,000.00");

        String decimalFormatted1 = df.format(i1);
        String decimalFormatted0 = df.format(d0);
        String decimalFormatted4 = df.format(d4);
        System.out.println(i1 + " -> " + decimalFormatted1); // 1234 -> 1,234.00
        System.out.println(d0 + " -> " + decimalFormatted0); // 1234.0 -> 1,234.00
        System.out.println(d4 + " -> " + decimalFormatted4); // 1234.5678 -> 1,234.57
    }

    public static void main(String[] args) {
        FormatDemo demo = new FormatDemo();
        // demo.formatStrings();
        demo.formatNumbers();

    }

}
