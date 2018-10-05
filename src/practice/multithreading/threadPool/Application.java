package practice.multithreading.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by asaxena on 8/27/2018.
 */
class Task implements Runnable{
    private int id;
    public Task(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("Started: "+id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished: "+id);
    }
}
public class Application {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i=1;i<=5;i++){
            executor.execute(new Task(i));
        }
        executor.shutdown();
    }
}
