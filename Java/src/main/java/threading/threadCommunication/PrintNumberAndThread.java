package threading.threadCommunication;

//Print 1: thread 1
//2: thread2
//3: thread3
//4: thread1
//5: thread2
//6: thread3
public class PrintNumberAndThread {
    volatile int count = 1;
    final int maxCount;
    int noOfThreads;

    public PrintNumberAndThread(int maxCount, int noOfThreads) {
        this.maxCount = maxCount;
        this.noOfThreads = noOfThreads;
    }

    public void printNumbers(int threadNumber) throws InterruptedException {
        synchronized (this) {
            while (count <= maxCount - noOfThreads + 1) { // Fixed condition
                if (count > maxCount) { // Ensure threads exit properly
                    notifyAll(); // Notify remaining threads before exiting
                    break;
                }
                while (count % noOfThreads != threadNumber) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(count + ": " + Thread.currentThread().getName());
                count++;
                notifyAll();// Notify all threads to proceed
                Thread.sleep(100); // Sleep for 1 second
            }

        }

    }
}

class ThreadPrint implements Runnable {
    PrintNumberAndThread printNumberAndThread;
    int threadNumber;

    public ThreadPrint(PrintNumberAndThread printNumberAndThread, int threadNumber) {
        super();
        this.printNumberAndThread = printNumberAndThread;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        try{printNumberAndThread.printNumbers(threadNumber);}
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Main {
    public static int noOfThreads = 11; // Total number of threads
    public static int maxCount = 55;  // Maximum number to print

    public static void main(String[] args) {
        PrintNumberAndThread printNumberAndThread = new PrintNumberAndThread(maxCount, noOfThreads);
        int threadNumber = 0;
        // Create and start threads
        for (int i = 1; i <= noOfThreads; i++) {
            if (i == noOfThreads) {
                threadNumber = 0;
            } else {
                threadNumber = i;
            }
            Thread thread = new Thread(new ThreadPrint(printNumberAndThread, threadNumber), "Thread " + i);
            thread.start();

        }

    }
}