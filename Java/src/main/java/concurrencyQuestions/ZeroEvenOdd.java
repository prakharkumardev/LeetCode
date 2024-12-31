package concurrencyQuestions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class ZeroEvenOdd {

    private int n;
    private AtomicInteger counter; // Counter to track the sequence
    private volatile int state;   // 0 for zero, 1 for odd, 2 for even

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.counter = new AtomicInteger(1);
        this.state = 0; // Start with zero
    }

    // Print zero
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                wait();
            }
            printNumber.accept(0); // Print zero
            state = (counter.get() % 2 == 0) ? 2 : 1; // Determine next state (odd or even)
            notifyAll();
        }
    }

    // Print even numbers
    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                wait();
            }
            printNumber.accept(counter.getAndIncrement()); // Print even number
            state = 0; // Switch back to zero
            notifyAll();
        }
    }

    // Print odd numbers
    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                wait();
            }
            printNumber.accept(counter.getAndIncrement()); // Print odd number
            state = 0; // Switch back to zero
            notifyAll();
        }
    }
}