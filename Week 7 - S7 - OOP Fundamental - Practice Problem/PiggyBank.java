class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        } else {
            System.out.println("Withdrawal rejected: insufficient funds or invalid amount.");
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}

public class PiggyBankTest {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("savings = " + pb.getSavings()); // 100
        pb.withdraw(30);
        System.out.println("savings = " + pb.getSavings()); // 70
        pb.withdraw(500); // rejected
        System.out.println("savings stays " + pb.getSavings()); // 70
    }
}