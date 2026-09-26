import java.util.Scanner;

abstract class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double salary) { super(name, salary); }
    double calculateBonus() { return salary * 0.10; }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double salary) { super(name, salary); }
    double calculateBonus() { return salary * 0.05; }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double salary) { super(name, salary); }
    double calculateBonus() { return 2000.0; }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotalBonus = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            Employee emp = null;

            if (type.equals("FULLTIME")) {
                emp = new FullTimeEmployee(name, salary);
            } else if (type.equals("PARTTIME")) {
                emp = new PartTimeEmployee(name, salary);
            } else if (type.equals("INTERN")) {
                emp = new InternEmployee(name, salary);
            }

            if (emp != null) {
                double bonus = emp.calculateBonus();
                grandTotalBonus += bonus;
                System.out.printf("%s: %.2f\n", emp.name, bonus);
            }
        }
        System.out.printf("Total Bonus: %.2f\n", grandTotalBonus);
        sc.close();
    }
}