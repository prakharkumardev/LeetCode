package threading.synchronization;

public class MyThread implements Runnable{

    private Counter counter;
    public MyThread(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        //synchronized (counter) {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        //}
    }
}
