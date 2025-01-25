package mk;

public class Account {

    // Keep track of the total number of accounts
    private static int totalAccounts;

    private double balance;

    public Account(double initialBalance) {
        totalAccounts++;
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

    // static: To get the total number of accounts, we don't need an instance of the
    // Account class. We simply need to know the global count maintained by the
    // class itself.
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {

        Account acc1 = new Account(0);
        Account acc2 = new Account(100);
        Account acc3 = new Account(200);

        System.out.println("Total accounts: " + Account.getTotalAccounts()); // 3

        System.out.println(acc2);

        acc2.withdraw(1);

        System.out.println(acc2);

    }
}
