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
}
