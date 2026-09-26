import java.util.Scanner;

abstract class Delivery {
    double weight, distance;
    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }
    abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double w, double d) { super(w, d); }
    double calculateFee() { return 5.0 + (0.50 * weight) + (0.10 * distance); }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double w, double d) { super(w, d); }
    double calculateFee() { return 15.0 + (1.00 * weight) + (0.20 * distance); }
}

class InternationalDelivery extends Delivery {
    double customsFee;
    public InternationalDelivery(double w, double d, double customsFee) {
        super(w, d);
        this.customsFee = customsFee;
    }
    double calculateFee() { return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee; }
}

public class DeliveryCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if (type.equals("STANDARD")) {
                double w = sc.nextDouble();
                double d = sc.nextDouble();
                Delivery del = new StandardDelivery(w, d);
                double fee = del.calculateFee();
                grandTotal += fee;
                System.out.printf("STANDARD: %.2f\n", fee);
            } else if (type.equals("EXPRESS")) {
                double w = sc.nextDouble();
                double d = sc.nextDouble();
                Delivery del = new ExpressDelivery(w, d);
                double fee = del.calculateFee();
                grandTotal += fee;
                System.out.printf("EXPRESS: %.2f\n", fee);
            } else if (type.equals("INTERNATIONAL")) {
                double w = sc.nextDouble();
                double d = sc.nextDouble();
                double customs = sc.nextDouble();
                Delivery del = new InternationalDelivery(w, d, customs);
                double fee = del.calculateFee();
                grandTotal += fee;
                System.out.printf("INTERNATIONAL: %.2f\n", fee);
            }
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}