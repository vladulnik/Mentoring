package workWithGenerics.bounds;

public class PowerBox<T extends Number> {

    private final T value;

    public PowerBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public double pow(int exponent) {
        return Math.pow(value.doubleValue(), exponent);
    }
}

