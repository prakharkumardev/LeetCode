package threading.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class completableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> {
            try{
                System.out.println("Task started.");
                Thread.sleep(1000);
                System.out.println("Task executed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "CompletableFuture: Task executed.";
        }).thenApply(result -> {
            return result + " Task completed.";
        });

        String result = task.get();
        System.out.println(result);
        System.out.println("Main thread completed.");
    }
}
