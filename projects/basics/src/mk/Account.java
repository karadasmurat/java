package mk;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) {

        // declares a local variable: Shadowing the instance variable!
        double balance = this.balance - amount;

        System.out.println("Withdraw: " + amount);
        System.out.println("Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {

        return "Account(" + this.balance + ")";
    }

    public static void main(String[] args) {

        Account acc = new Account(100);

        System.out.println(acc);

        acc.withdraw(1);

        System.out.println(acc);

    }
}
