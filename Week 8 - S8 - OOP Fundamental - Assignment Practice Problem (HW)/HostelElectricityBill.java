import java.util.Scanner;

abstract class Room {
    int units;

    public Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) { super(units); }
    double calculateBill() { return units * 8.0; }
}

class SharedRoom extends Room {
    int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class AcRoom extends Room {
    public AcRoom(int units) { super(units); }
    double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            Room room = null;

            if (type.equals("SINGLE")) {
                int units = sc.nextInt();
                room = new SingleRoom(units);
                System.out.print("SINGLE: ");
            } else if (type.equals("SHARED")) {
                int units = sc.nextInt();
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
                System.out.print("SHARED: ");
            } else if (type.equals("AC")) {
                int units = sc.nextInt();
                room = new AcRoom(units);
                System.out.print("AC: ");
            }

            if (room != null) {
                double bill = room.calculateBill();
                grandTotal += bill;
                System.out.printf("%.2f\n", bill);
            }
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}