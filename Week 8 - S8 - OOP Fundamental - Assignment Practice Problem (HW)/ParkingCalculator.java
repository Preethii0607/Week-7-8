import java.util.Scanner;

abstract class Vehicle {
    int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }
    double calculateCharge() { return hours * 10.0; }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }
    double calculateCharge() {
        if (hours <= 1) {
            return 30.0;
        } else {
            return 30.0 + (hours - 1) * 20.0;
        }
    }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }
    double calculateCharge() {
        double charge = hours * 50.0;
        return Math.max(charge, 100.0);
    }
}

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle vehicle = null;

            if (type.equals("BIKE")) {
                vehicle = new Bike(hours);
                System.out.print("BIKE: ");
            } else if (type.equals("CAR")) {
                vehicle = new Car(hours);
                System.out.print("CAR: ");
            } else if (type.equals("TRUCK")) {
                vehicle = new Truck(hours);
                System.out.print("TRUCK: ");
            }

            if (vehicle != null) {
                double charge = vehicle.calculateCharge();
                grandTotal += charge;
                System.out.printf("%.2f\n", charge);
            }
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}