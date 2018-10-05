package practice.multithreading.creatingThreads.demo3;

/**
 * Created by asaxena on 8/27/2018.
 */
public class Application {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            practice.multithreading.creatingThreads.demo1.Application application = new practice.multithreading.creatingThreads.demo1.Application();
            @Override
            public void run() {
                application.runJob();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            practice.multithreading.creatingThreads.demo1.Application application = new practice.multithreading.creatingThreads.demo1.Application();
            @Override
            public void run() {
                application.runJob();
            }
        });
        t2.start();

    }
}
