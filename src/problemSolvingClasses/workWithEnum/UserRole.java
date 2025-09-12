package problemSolvingClasses.workWithEnum;

public enum UserRole {
    GUEST,
    USER,
    ADMIN;

    public boolean hasAccessToSettings() {
        return switch (this) {
            case USER, ADMIN -> true;
            case GUEST -> false;
        };
    }
}
