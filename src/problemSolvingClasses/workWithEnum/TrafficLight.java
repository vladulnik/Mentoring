package problemSolvingClasses.workWithEnum;

public enum TrafficLight {
    RED,
    YELLOW,
    GREEN;

    public TrafficLight next() {
        return switch (this) {
            case RED -> GREEN;
            case YELLOW -> RED;
            case GREEN -> YELLOW;
        };
    }
}
