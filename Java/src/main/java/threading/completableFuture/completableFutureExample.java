package threading.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class completableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> {
//            try{
//                System.out.println("Task started.");
//                Thread.sleep(1000);
//                System.out.println("Task executed.");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "CompletableFuture: Task executed.";
//        }).thenApply(result -> {
//            return result + " Task completed.";
//        });
//
//        String result = task.get();
//        System.out.println(result);
//        System.out.println("Main thread completed.");




        CompletableFuture<String> cf1 = new CompletableFuture<>();
        cf1 = CompletableFuture.supplyAsync(()->{
            return "Completable task completed";
        });
//                .thenApply(res ->{
//            System.out.println(res);
//            return "Task Completed";
//        });

        String ans = cf1.get();
        System.out.println(ans);
        System.out.println("Main Completed");
    }
}
