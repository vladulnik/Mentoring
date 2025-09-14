package workWithGenerics.bounds;

import java.util.ArrayList;
import java.util.List;

public class SumBox<T extends Number>{
    private List<T> numbers;

    public SumBox() {
        this.numbers = new ArrayList<>();
    }

    public void add(T number) {
        numbers.add(number);
    }

    public double sum() {
        double total = 0;
        for(T num : numbers) {
            total += num.doubleValue();
        }
        return total;
    }
}
