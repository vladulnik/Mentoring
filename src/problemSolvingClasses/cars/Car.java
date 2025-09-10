package problemSolvingClasses.cars;

public class Car extends Vehicle{

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    public void refuel() {
        System.out.println("Need fuel");
    }
}
