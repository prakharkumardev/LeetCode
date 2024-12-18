package threading;

public class MyThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread running at " + Thread.currentThread().getName());
        System.out.println("Thread id is " + Thread.currentThread().getId());

    }
}
