package concurrencyQuestions;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;
    private Lock lock;
    private AtomicBoolean flagFoo;

    public FooBar(int n) {
        this.n = n;
        flagFoo = new AtomicBoolean(true);
        lock = new ReentrantLock();
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flagFoo.get()) {
                //wait for printFoo to be true
            }
            lock.lock();

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flagFoo.set(!flagFoo.get());
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flagFoo.get()) {
                //wait for printFoo to be false
            }
            lock.lock();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flagFoo.set(!flagFoo.get());
            lock.unlock();
        }
    }
}

