import java.time.LocalDate;
import java.util.Scanner;

abstract class Subscription {
    String name;
    LocalDate startDate;

    public Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends Subscription {
    public BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    LocalDate calculateRenewalDate() { return startDate.plusDays(30); }
}

class StandardPlan extends Subscription {
    public StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    LocalDate calculateRenewalDate() { return startDate.plusDays(90); }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    LocalDate calculateRenewalDate() { return startDate.plusDays(365); }
}

public class StreamingRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate startDate = LocalDate.parse(dateStr);
            Subscription sub = null;

            if (type.equals("BASIC")) {
                sub = new BasicPlan(name, startDate);
            } else if (type.equals("STANDARD")) {
                sub = new StandardPlan(name, startDate);
            } else if (type.equals("PREMIUM")) {
                sub = new PremiumPlan(name, startDate);
            }

            if (sub != null) {
                LocalDate renewalDate = sub.calculateRenewalDate();
                System.out.println(sub.name + ": " + renewalDate);
            }
        }
        sc.close();
    }
}