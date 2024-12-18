package threading.threadMethods;

public class DeamonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello world! ");
        }
    }

    public static void main(String[] args) {
        DeamonThread deamonThread = new DeamonThread();
        deamonThread.setDaemon(true); // myThread is daemon thread ( like Garbage collector ) now

        deamonThread.start();
        System.out.println("Main Done");
    }
}
