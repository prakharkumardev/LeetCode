package concurrencyQuestions;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {
    private AtomicInteger atomicInteger;
    public PrintInOrder() {
         atomicInteger = new AtomicInteger(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        while(atomicInteger.get() != 1){
            //wait for atomicInteger to be 1

        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        atomicInteger.incrementAndGet();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (atomicInteger.get() != 2){
            //wait for atomicInteger to be 2
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        atomicInteger.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (atomicInteger.get() != 3){
            //wait for atomicInteger to be 3
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }
}
