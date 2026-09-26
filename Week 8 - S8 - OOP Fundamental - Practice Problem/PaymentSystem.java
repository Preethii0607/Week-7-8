import java.util.Scanner;

abstract class Payment {
    double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAdjustedAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }
    double calculateAdjustedAmount() { return amount * 1.02; }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) { super(amount); }
    double calculateAdjustedAmount() { return amount * 1.01; }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) { super(amount); }
    double calculateAdjustedAmount() { return amount; }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amt = sc.nextDouble();
            Payment p = null;

            if (type.equals("CARD")) {
                p = new CardPayment(amt);
                System.out.print("CARD: ");
            } else if (type.equals("WALLET")) {
                p = new WalletPayment(amt);
                System.out.print("WALLET: ");
            } else if (type.equals("BANKTRANSFER")) {
                p = new BankTransferPayment(amt);
                System.out.print("BANKTRANSFER: ");
            }

            if (p != null) {
                double adjusted = p.calculateAdjustedAmount();
                total += adjusted;
                System.out.printf("%.2f\n", adjusted);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}