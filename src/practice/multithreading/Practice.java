package practice.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by asaxena on 8/28/2018.
 */
public class Practice {
    public static void criticalSection(String tName) throws InterruptedException {
        System.out.println(tName + " Entering critical section!!!");
        Thread.sleep(2000);
        System.out.println(tName + " Exiting critical section!!!");
    }
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("Thread 1");
                    lock.lock();
                    criticalSection("Thread 1");
                    lock.lock();
                    criticalSection("Thread 1");
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("Thread 2");
                    lock.lock();
                    criticalSection("Thread 2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });


        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Finished!!!");
    }
}
