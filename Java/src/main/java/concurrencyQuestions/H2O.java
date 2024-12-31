package concurrencyQuestions;

import java.util.concurrent.atomic.AtomicInteger;

public class H2O {
    AtomicInteger hydrogenCount;
    AtomicInteger oxygenCount;

    public H2O() {
        hydrogenCount = new AtomicInteger(0);
        oxygenCount = new AtomicInteger(0);
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (hydrogenCount.get() == 2) {
            wait();
        }
        hydrogenCount.incrementAndGet();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        notify();
        if(hydrogenCount.get() == 2 && oxygenCount.get() == 1) {
            hydrogenCount.set(0);
            oxygenCount.set(0);
        }

    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (oxygenCount.get() == 1) {
            wait();
        }
        oxygenCount.incrementAndGet();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        if (hydrogenCount.get() == 2 && oxygenCount.get() == 1) {
            hydrogenCount.set(0);
            oxygenCount.set(0);
        }
    }
}
