package threading;

public class ThreadLifeCycle extends Thread{
    @Override
    public void run() {
        System.out.println("RUNNING"); // RUNNING
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifeCycle t1 = new ThreadLifeCycle();
        System.out.println(t1.getState()); // NEW
        t1.start();
        System.out.println(t1.getState()); // RUNNABLE
        Thread.sleep(100);
        System.out.println(t1.getState()); // TIMED_WAITING
        t1.join();
        System.out.println(t1.getState()); // TERMINATED
    }


    public static class ThreadMethods{
        public static class MyTh extends Thread{
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(i);
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            Thread t1 = new Thread(new MyTh());
            t1.start();
            System.out.println(t1.getState());
            t1.join();
            System.out.println(t1.getState());
        }
    }

    public static class ThreadPriority{
        public static class MyThread extends Thread{

            public MyThread(String name) {
                super(name);
            }
            @Override
            public void run() {
                for (int i = 0;i<5;i++){
                    StringBuffer a = new StringBuffer();
                    a.append("a".repeat(100000));

                    System.out.println(Thread.currentThread().getName() +"Priority: " + Thread.currentThread().getPriority()+" count: "+i);
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        public static void main(String[] args) {
            MyThread t1 = new MyThread("Low Priority Thread");
            MyThread t2 = new MyThread("Normal Priority Thread");
            MyThread t3 = new MyThread("High Priority Thread");
            t1.setPriority(Thread.MIN_PRIORITY);
            t2.setPriority(Thread.NORM_PRIORITY);
            t3.setPriority(Thread.MAX_PRIORITY);
            t1.start();
            t2.start();
            t3.start();
        }
    }











}



