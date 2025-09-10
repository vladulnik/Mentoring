package problemSolvingClasses.figures;

public class Triangle extends Shape {

    private final double firstSide;
    private final double secondSide;
    private final double thirdSide;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
    }

    @Override
    public double calculatePerimeter() {
        return firstSide + secondSide + thirdSide;
    }
}
