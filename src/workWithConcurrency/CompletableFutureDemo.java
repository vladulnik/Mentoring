package workWithConcurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        Supplier<Integer> task = () -> 1;
        var future = CompletableFuture.supplyAsync(task);
        try {
            var result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
