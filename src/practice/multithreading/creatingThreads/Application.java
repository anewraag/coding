package practice.multithreading.creatingThreads;

/**
 * Created by asaxena on 8/27/2018.
 */
public class Application {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                practice.multithreading.creatingThreads.demo1.Application application = new practice.multithreading.creatingThreads.demo1.Application();
                application.runJob();
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                practice.multithreading.creatingThreads.demo1.Application application = new practice.multithreading.creatingThreads.demo1.Application();
                application.runJob();
            }
        };
        t2.start();
        t1.start();
    }
}
