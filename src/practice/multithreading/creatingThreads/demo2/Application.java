package practice.multithreading.creatingThreads.demo2;

/**
 * Created by asaxena on 8/27/2018.
 */


class Runner implements Runnable{
    practice.multithreading.creatingThreads.demo1.Application application = new practice.multithreading.creatingThreads.demo1.Application();

    public void run(){
        application.runJob();
    }
}
public class Application {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner());
        Thread t2 = new Thread(new Runner());
        t1.start();
        t2.start();
    }
}
