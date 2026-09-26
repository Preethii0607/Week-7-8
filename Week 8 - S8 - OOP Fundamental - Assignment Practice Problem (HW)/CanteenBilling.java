import java.util.Scanner;

abstract class Bill {
    double amount;

    public Bill(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();
}

class StudentBill extends Bill {
    public StudentBill(double amount) { super(amount); }
    double calculateFinalAmount() { return amount * 0.90; }
}

class StaffBill extends Bill {
    public StaffBill(double amount) { super(amount); }
    double calculateFinalAmount() { return amount * 0.95; }
}

class GuestBill extends Bill {
    public GuestBill(double amount) { super(amount); }
    double calculateFinalAmount() { return amount + 10.0; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amt = sc.nextDouble();
            Bill bill = null;

            if (type.equals("STUDENT")) {
                bill = new StudentBill(amt);
                System.out.print("STUDENT: ");
            } else if (type.equals("STAFF")) {
                bill = new StaffBill(amt);
                System.out.print("STAFF: ");
            } else if (type.equals("GUEST")) {
                bill = new GuestBill(amt);
                System.out.print("GUEST: ");
            }

            if (bill != null) {
                double finalAmt = bill.calculateFinalAmount();
                grandTotal += finalAmt;
                System.out.printf("%.2f\n", finalAmt);
            }
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}