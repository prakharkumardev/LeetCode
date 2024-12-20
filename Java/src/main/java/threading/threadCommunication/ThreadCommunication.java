package threading.threadCommunication;

class SharedResource {
    private int data;
    private boolean hasData;

    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized int consume(String threadName) {
        while (!hasData){
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data+ " by " + threadName);
        notifyAll();
        return data;
    }
}

class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            resource.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = resource.consume(Thread.currentThread().getName());
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource), "Producer");
        Thread consumerThread1 = new Thread(new Consumer(resource), "Consumer1");
        Thread consumerThread2 = new Thread(new Consumer(resource), "Consumer2");

        producerThread.start();
        consumerThread1.start();
        //consumerThread1.join();
        consumerThread2.start();
    }
}