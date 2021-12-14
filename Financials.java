// Represents the bank account/on hand money of the player, and allows for
// withdrawal and deposit
public class Financials {
    private double balance; // Represents the total balance in the account

    public Financials(double balance) {
        this.balance = balance;
    }

    // Retrieves the balance
    public double getBalance() {
        return balance;
    }

    // Deposits money into the balance, but has a minimum deposit value
    public String deposit(double amount) {
        double MIN_DEPOSIT = 0.01;
        if (amount < MIN_DEPOSIT) {
            return "You must deposit at least $0.01 in your account!";
        }
        balance += amount;
        return "You now have $" + balance + " in your account!";
    }

    // Withdraws money from the balance, but limited by amount in balance
    public String withdraw(double amount) {
        balance -= amount;
        return "You now have $" + balance + " in your account";
    }

    public static void main(String[] args) {
        Financials fin = new Financials(100);
        StdOut.println(fin.getBalance());
        StdOut.println(fin.deposit(10.5));
        StdOut.println(fin.deposit(0));
        StdOut.println(fin.withdraw(200));
        StdOut.println(fin.withdraw(60));
        StdOut.println(fin.getBalance());
    }
}
