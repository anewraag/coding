package practice.multithreading.locks;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by asaxena on 8/28/2018.
 */
public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account(1);
        Account acc2 = new Account(2);

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Random random = new Random();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Worker worker = new Worker();
                for(int i=0;i<1000;i++) {
                    lock1.lock();
                    lock2.lock();
                    try {
                        worker.transfer(acc1, acc2, random.nextInt(acc1.showBalance()));
                    }
                    finally {
                        lock1.unlock();
                        lock2.unlock();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Worker worker = new Worker();
                for(int i=0;i<1000;i++) {
                    lock2.lock();
                    lock1.lock();
                    try {
                        worker.transfer(acc2, acc1, random.nextInt(acc1.showBalance()));
                    }
                    finally {
                        lock2.unlock();
                        lock1.unlock();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Transaction Finished!!!");
    }
}
