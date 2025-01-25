package exercises;

public class Exercise {

    public void countTo(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + "");
        }

    }

    public boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        System.out.println("PRIME detected:" + n);
        return true;
    }

    // TODO
    public void categorize(int[] ages) {
        for (var age : ages) {
            System.out.println(age);
        }
    }

    public void drawRect(char c, int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("width and height should be positive");
        }

        for (int i = 0; i < height; i++) {
            // for (int j = 0; j < width; j++) {
            // System.out.print(c);
            // }
            // System.out.print("\n");
            drawLine(c, width);

        }
    }

    public void drawTriangle(char c, int height) {
        for (int i = 0; i <= height; i++) {
            drawLine(c, i);
        }
    }

    public void drawLine(char c, int width) {
        for (int j = 0; j < width; j++) {
            System.out.print(c);
        }
        System.out.print("\n");
    }

}
