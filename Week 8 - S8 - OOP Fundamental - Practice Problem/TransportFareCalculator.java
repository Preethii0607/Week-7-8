import java.util.Scanner;

abstract class Journey {
    double distance;
    public Journey(double distance) { this.distance = distance; }
    abstract double calculateFare();
}

class BusJourney extends Journey {
    public BusJourney(double distance) { super(distance); }
    double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }
}

class TrainJourney extends Journey {
    public TrainJourney(double distance) { super(distance); }
    double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroJourney extends Journey {
    double peakHourFactor;
    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }
    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if (type.equals("BUS")) {
                double dist = sc.nextDouble();
                Journey j = new BusJourney(dist);
                double fare = j.calculateFare();
                grandTotal += fare;
                System.f.printf("BUS: %.2f\n", fare);
            } else if (type.equals("TRAIN")) {
                double dist = sc.nextDouble();
                Journey j = new TrainJourney(dist);
                double fare = j.calculateFare();
                grandTotal += fare;
                System.out.printf("TRAIN: %.2f\n", fare);
            } else if (type.equals("METRO")) {
                double dist = sc.nextDouble();
                double factor = sc.nextDouble();
                Journey j = new MetroJourney(dist, factor);
                double fare = j.calculateFare();
                grandTotal += fare;
                System.out.printf("METRO: %.2f\n", fare);
            }
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}