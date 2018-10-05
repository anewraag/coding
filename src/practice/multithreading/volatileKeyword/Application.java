package practice.multithreading.volatileKeyword;

import java.util.Scanner;

/**
 * Created by asaxena on 8/27/2018.
 */
class Runner extends Thread{

    private volatile Boolean isRunning = true;
    private volatile int count = 0;

    public void run(){
        while(isRunning){
            count++;
            System.out.println(count + ". Thread is running!!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setCount(int count){
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public void shutdown(){
        isRunning = false;
    }
}
public class Application {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();

        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        runner.setCount(cnt);

        System.out.println("Runner count:" + runner.getCount());

        scanner.nextLine();
        scanner.nextLine();
        runner.shutdown();
    }
}
