class AttendanceSheet {
    private String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxCapacity) {
        this.presentStudents = new String[maxCapacity];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return; // Already marked, avoid duplicates
        }
        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class AttendanceSheetTest {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // Duplicate, won't increase count

        System.out.println("Present count: " + sheet.getPresentCount()); // 2
        System.out.println("Is Ben present? " + sheet.isPresent("Ben")); // true
        System.out.println("Is Chen present? " + sheet.isPresent("Chen")); // false
    }
}