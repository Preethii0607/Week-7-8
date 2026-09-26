class Locker {
    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combination = initialCode;
    }

    public void changeCode(String currentCode, String newCode) {
        if (this.combination.equals(currentCode)) {
            this.combination = newCode;
            System.out.println("Success: Code changed.");
        } else {
            System.out.println("Rejected: Incorrect current code. Code remains unchanged.");
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class LockerTest {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678"); // success
        l.changeCode("0000", "9999"); // rejected
    }
}