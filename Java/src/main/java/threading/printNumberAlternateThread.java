package threading;

import java.time.Duration;
import java.time.Instant;

public class printNumberAlternateThread {

    private boolean isOdd = true;

    public synchronized void printOdd(int number) {
        Instant startTime = Instant.now();
        Instant currentTime = Instant.now();
        while (!isOdd){
            currentTime = Instant.now();
//            if (Duration.between(startTime, currentTime).toNanos() > 5) {
//                System.out.println("Waited for 5 seconds, resuming execution...");
//                break; // Exit the loop after 5 seconds
//            }
            try {
                wait();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isOdd = false;
        System.out.println("Odd: " + number + " " + Thread.currentThread().getId());
        notifyAll();
    }

    public synchronized void printEven(int number) {
        Instant startTime = Instant.now();
        Instant currentTime = Instant.now();
        while (isOdd) {
            currentTime = Instant.now();
//            if (Duration.between(startTime, currentTime).toNanos() > 5) {
//                System.out.println("Waited for 5 seconds, resuming execution...");
//                break; // Exit the loop after 5 seconds
//            }
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isOdd = true;
        System.out.println("Even: " + number+ " " + Thread.currentThread().getId());
        notifyAll();
    }

    public class printOddThread implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i += 2) {
                printOdd(i);
            }
        }
    }

    public class printEvenThread implements Runnable {
        public void run() {
            for (int i = 2; i <= 10; i += 2) {
                printEven(i);
            }
        }
    }


    public void main() {
        Thread t1 = new Thread(new printOddThread());
        Thread t2 = new Thread(new printEvenThread());
        t1.start();
        t2.start();

    }
}
