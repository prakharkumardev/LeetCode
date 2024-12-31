package concurrencyQuestions;

import java.util.concurrent.Semaphore;

public class  Foo {
        private Semaphore semaphore1;
        private Semaphore semaphore2;
        public Foo() throws InterruptedException {
            semaphore1 = new Semaphore(1, true);
            semaphore2 = new Semaphore(1, true);
            semaphore1.acquire();
            semaphore2.acquire();

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphore1.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (!semaphore1.tryAcquire()){
                //wait for semaphore 1 to release
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            semaphore2.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (!semaphore2.tryAcquire()){
                //wait for semaphore 2 to release
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

        }
    }

