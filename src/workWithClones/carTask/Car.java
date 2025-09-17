package workWithClones.carTask;

public final class Car {
    private final String model;
    private final Engine engine;
    private final int[] serviceHistory;

    public Car(String model, Engine engine, int[] serviceHistory) {
        this.model = model;
        this.engine = engine.clone();
        this.serviceHistory = serviceHistory.clone();
    }

    @Override
    public Car clone() {
        return new Car(this.model, this.engine.clone(), this.serviceHistory.clone());
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine.clone();
    }

    public int[] getServiceHistory() {
        return serviceHistory.clone();
    }
}
