public class Financials {
    private double balance;

    public Financials(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String deposit(double amount) {
        double MIN_DEPOSIT = 0.01;
        if (amount < MIN_DEPOSIT) {
            return "You must deposit at least $0.01 in your account!";
        }
        balance += amount;
        return "You now have $" + balance + " in your account!";
    }

    public String withdraw(double amount) {
        if (amount > balance) {
            return "Are you broke? You don't have that kind of money!";
        }
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
