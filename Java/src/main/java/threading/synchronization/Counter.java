package threading.synchronization;

public class Counter {
    int count;
    public Counter() {
        count = 0;
    }
    public synchronized void increment() {
        count++;
    }
    public int getValue() {
        return count;
    }
}


