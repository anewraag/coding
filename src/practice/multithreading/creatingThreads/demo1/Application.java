package practice.multithreading.creatingThreads.demo1;

/**
 * Created by asaxena on 8/27/2018.
 */
class Runner extends Thread{
    public void runJob(){
        for(int i=1;i<=10;i++){
            System.out.println("Counter: "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void run(){
        runJob();
    }
}
public class Application {

    public static void main(String[] args) {
        Runner runner1 = new Runner();
        Runner runner2 = new Runner();
        runner1.start();
        runner2.start();
    }

    public void runJob(){
        Runner runner = new Runner();
        runner.runJob();
    }
}
