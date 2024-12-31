package threading.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FairnessLockExample {
    //private final Lock lock = new ReentrantLock(true);
    //to make lock unfare: private final Lock lock = new ReentrantLock(false);
    private final Lock lock = new ReentrantLock(false);
    public void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            Thread.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FairnessLockExample example = new FairnessLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };
        for(int i = 0 ;i< 1000;i++){
            Thread thread = new Thread(task, "Thread " + i);
            thread.start();
        }
//        Thread thread1 = new Thread(task, "Thread 1");
//        Thread thread2 = new Thread(task, "Thread 2");
//        Thread thread3 = new Thread(task, "Thread 3");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
    }
}