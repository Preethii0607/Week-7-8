class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length >= 6 && length < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class PasswordCheckerTest {
    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println(pc.getStrength()); // Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println(pc2.getStrength()); // Strong
    }
}