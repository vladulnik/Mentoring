package workWithGenerics.bounds;

public class MinMax<T extends Comparable<T>> {
    private T[] elements;

    public MinMax(T[] elements) {
        if(elements == null || elements.length == 0) {
            throw new IllegalArgumentException("Array cant be empty");
        }
        this.elements = elements;
    }

    public T min() {
        T result = elements[0];
        for(int i = 1; i < elements.length; i++) {
            if(elements[i].compareTo(result) < 0) {
                result = elements[i];
            }
        }
        return result;
    }

    public T max() {
        T result = elements[0];
        for(int i = 1; i < elements.length; i++) {
            if(elements[i].compareTo(result) > 0) {
                result = elements[i];
            }
        }
        return result;
    }
}
