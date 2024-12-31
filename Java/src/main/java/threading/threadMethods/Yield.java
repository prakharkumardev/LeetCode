package threading.threadMethods;

public class Yield extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is running...");
                try {
                    Thread.yield();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }

        public static void main(String[] args) {
            Yield t1 = new Yield();
            Yield t2 = new Yield();
            t1.start();
            t2.start();
        }

}
