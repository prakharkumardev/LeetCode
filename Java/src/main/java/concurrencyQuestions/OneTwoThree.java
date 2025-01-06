package concurrencyQuestions;

public class OneTwoThree {


    private static int num = 1; // Shared resource
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (num <= 10) {
                synchronized (lock) {
                    while (num % 3 != 1) { // Condition for thread t1
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (num <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                        num++;
                    }
                    lock.notifyAll();
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            while (num <= 10) {
                synchronized (lock) {
                    while (num % 3 != 2) { // Condition for thread t2
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (num <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                        num++;
                    }
                    lock.notifyAll();
                }
            }
        }, "Thread-2");

        Thread t3 = new Thread(() -> {
            while (num <= 10) {
                synchronized (lock) {
                    while (num % 3 != 0) { // Condition for thread t3
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (num <= 10) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                        num++;
                    }
                    lock.notifyAll();
                }
            }
        }, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }


}
