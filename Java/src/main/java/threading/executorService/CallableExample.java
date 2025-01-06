package threading.executorService;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        Callable<String> task = () -> {
            return "Callable: Task executed.";
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(task);
        try {
            String result = future.get(); // Waits for and retrieves the result
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
