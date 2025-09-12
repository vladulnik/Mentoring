package problemSolvingClasses.workWithEnum;

public enum LengthUnit {
    METER(1.0),
    KILOMETER(1000.0),
    CENTIMETER(0.01),
    MILLIMETER(0.001);

    private final double value;

    LengthUnit(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public double convert(double value, LengthUnit target) {
        double inMeters = value * this.getValue();
        return inMeters / target.getValue();
    }
}
