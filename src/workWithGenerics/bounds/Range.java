package workWithGenerics.bounds;

public class Range<T extends Comparable<T>> {
    private final T min;
    private final T max;

    public Range(T min, T max) {
        if(max.compareTo(min) < 0) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

    public boolean contains(T value) {
        return value.compareTo(min) >= 0 && value.compareTo(max) <= 0;
    }

    public T clamp(T value) {
        if (value.compareTo(min) < 0) {
            return min;
        } else if (value.compareTo(max) > 0) {
            return max;
        } else {
            return value;
        }
    }

    public boolean isInside(Range<T> outer) {
        return this.max.compareTo(outer.max) <= 0 && this.min.compareTo(outer.min) >= 0;
    }

    public boolean intersects(Range<T> other) {
        return  this.max.compareTo(other.min) >= 0 && this.min.compareTo(other.max) <= 0;
    }
}
