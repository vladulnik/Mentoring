package problemSolvingClasses.workWithEnum;

public enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN;

    public Season next() {
        return switch (this) {
            case WINTER -> SPRING;
            case SPRING -> SUMMER;
            case SUMMER -> AUTUMN;
            case AUTUMN -> WINTER;
        };
    }
}
