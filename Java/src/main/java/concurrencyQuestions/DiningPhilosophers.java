package concurrencyQuestions;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

    Semaphore[] spoon;
    Semaphore maxPhilosophers;

    public DiningPhilosophers() {
        spoon = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            spoon[i] = new Semaphore(1);
        }
        maxPhilosophers = new Semaphore(4);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        maxPhilosophers.acquire();

        int leftForkId, rightForkId;
        if(philosopher == 0){
            leftForkId = 4;
            rightForkId = 0;
        } else{
            leftForkId = philosopher - 1;
            rightForkId = philosopher;
        }

        if(philosopher%2 ==0){
            spoon[leftForkId].acquire();
            spoon[rightForkId].acquire();
        }else {
            spoon[rightForkId].acquire();
            spoon[leftForkId].acquire();
        }

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        System.out.println("Philosopher " + philosopher + " is eating with spoon " + leftForkId + " and " + rightForkId);

        putLeftFork.run();
        putLeftFork.run();
        spoon[leftForkId].release();
        spoon[rightForkId].release();
        System.out.println("Philosopher " + philosopher + " has finished eating and given back spoon " + leftForkId + " and " + rightForkId);

        maxPhilosophers.release();

    }
}
