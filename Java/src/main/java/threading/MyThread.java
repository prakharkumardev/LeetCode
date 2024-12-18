package threading;

import java.sql.SQLOutput;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread running at " + Thread.currentThread().getName());
        System.out.println("Thread id is " + Thread.currentThread().getId());
    }
}

class runThread{


    public static void main(String[] args) {
            Thread thread = new Thread(new MyThread());
            thread.start();
            Thread thread1 = new Thread(new MyThreadRunnable());
            thread1.start();
            Thread thread2 = new Thread(()->{
                System.out.println("Thread running at " + Thread.currentThread().getName());
                System.out.println("Thread id is " + Thread.currentThread().getId());
            });
            thread2.start();

            //make all three thread run on a same thread we use run(),
            //When you call the run() method directly instead of start(),
            // the code executes in the main thread rather than creating separate threads
//            thread.run();
//            thread1.run();
//            thread2.run();
        }
}