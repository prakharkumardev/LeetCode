package concurrencyQuestions;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class H2OWithSemaphore {

    Semaphore hySemaphore;
    Semaphore oxSemaphore;

    public H2OWithSemaphore() {

        hySemaphore = new Semaphore(2);
        oxSemaphore = new Semaphore(0);
    }

    public  void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hySemaphore.acquire();
        releaseHydrogen.run();
        if(hySemaphore.availablePermits() == 0){
            oxSemaphore.release();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.


    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
       oxSemaphore.acquire();
        releaseOxygen.run();
        hySemaphore.release(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.

    }
}

