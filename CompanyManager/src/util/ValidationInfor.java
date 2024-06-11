package util;

public class ValidationInfor {
    public final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";

    public boolean validateEmail(String email) {
            return email.matches(EMAIL_PATTERN);
    }
}
