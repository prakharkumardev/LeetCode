package concurrencyQuestions;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintOneTwoThreeAtomicInteger {
    static AtomicInteger num = new AtomicInteger(1);
    static Object lock = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (num.get() <= 10) {
                synchronized (lock) {
                    while (num.get() % 3 != 1 && num.get() <= 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (num.get() <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + num.getAndIncrement());
                    }
                    lock.notifyAll();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (num.get() <= 10) {
                synchronized (lock) {
                    while (num.get() % 3 != 2 && num.get() <= 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (num.get() <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + num.getAndIncrement());
                    }
                    lock.notifyAll();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (num.get() <= 10) {
                synchronized (lock) {
                    while (num.get() % 3 != 0 && num.get() <= 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (num.get() <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + num.getAndIncrement());
                    }
                    lock.notifyAll();
                }
            }
        });
        t1.setName("First Thread");
        t2.setName("Second Thread");
        t3.setName("Third Thread");
        t1.start();
        t2.start();
        t3.start();
    }

}
