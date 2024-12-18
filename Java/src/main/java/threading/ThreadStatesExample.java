package threading;

public class ThreadStatesExample {

    public static void main(String[] args) throws InterruptedException {

        // NEW State: The thread is created but not started yet
        Thread newThread = new Thread(() -> {
            System.out.println("Thread is in RUNNABLE state");
        });

        // Display thread state (NEW state)
        System.out.println("Thread state after creation: " + newThread.getState()); // NEW

        // START the thread, transitioning it to RUNNABLE
        newThread.start();

        // Allow the thread to complete execution
        newThread.join(); // Block the main thread until 'newThread' finishes
        System.out.println("Thread state after completion: " + newThread.getState()); // TERMINATED


        // RUNNABLE State: The thread is ready to run, and the OS schedules it
        Thread runnableThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("RUNNABLE thread is executing");
            }
        });

        // Start the thread, moving it to RUNNABLE
        runnableThread.start();

        // Allow the thread to run for a short time
        Thread.sleep(1000); // Main thread sleeps to let 'runnableThread' execute
        System.out.println("Thread state while running: " + runnableThread.getState()); // RUNNABLE


        // BLOCKED State: The thread is blocked waiting for a synchronized lock
        Object lock = new Object();

        Thread blockedThread1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Blocked thread is running");
            }
        });

        Thread blockedThread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Blocked thread is running");
            }
        });

        // Start the first thread
        blockedThread1.start();

        // Start the second thread, but it will be blocked waiting for 'blockedThread1' to release the lock
        Thread.sleep(100); // Ensure 'blockedThread1' starts first
        blockedThread2.start();

        // The second thread should be blocked until the first one completes
        Thread.sleep(100); // Allow time for blockedThread2 to be blocked
        System.out.println("Thread state while blocked: " + blockedThread2.getState()); // BLOCKED


        // WAITING State: The thread is waiting indefinitely for another thread to notify it
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(); // Thread will wait indefinitely for notification
                    System.out.println("Waiting thread is notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start the waiting thread
        waitingThread.start();

        // Allow the thread to enter the waiting state
        Thread.sleep(100); // Ensure 'waitingThread' enters the wait state
        System.out.println("Thread state while waiting: " + waitingThread.getState()); // WAITING

        // Notify the waiting thread after a short delay
        synchronized (lock) {
            lock.notify();
        }

        // Allow time for waiting thread to complete
        waitingThread.join();


        // TIMED_WAITING State: The thread sleeps for a fixed time
        Thread timedWaitingThread = new Thread(() -> {
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
                System.out.println("Thread has finished sleeping");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the timed waiting thread
        timedWaitingThread.start();

        // Sleep for a short period, allowing timedWaitingThread to enter TIMED_WAITING state
        Thread.sleep(100); // Ensure timedWaitingThread starts sleeping
        System.out.println("Thread state while sleeping: " + timedWaitingThread.getState()); // TIMED_WAITING

        // Allow the timed waiting thread to finish
        timedWaitingThread.join();

        // TERMINATED State: The thread has finished execution
        System.out.println("Thread state after completion: " + timedWaitingThread.getState()); // TERMINATED
    }
}
