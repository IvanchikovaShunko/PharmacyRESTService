package by.fpmi.pharmacy.utils;

/**
 * Created by annashunko
 */
public enum  UserRole {
    ADMIN("ADMIN"),
    USER("USER");

    private final String value;

    private UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
