package practice.multithreading.synchronizedBlock;

/**
 * Created by asaxena on 8/27/2018.
 */

//Using volatile won;t help here as it is an issue of interleaving.
// The value of the variable is getting overwritten here.
class Counter{
    public volatile int value=0;
    public void inc(){value++;}
    public void dec(){value--;}
    public int get(){return value;};
}

//counter with synchronized method
class Counter1 extends Counter{
    synchronized public void inc(){
        value++;
    }
    synchronized public void dec(){
        value--;
    }
}

//counter with synchronized block
class Counter2  extends Counter{
    public void inc(){
        synchronized (this) {
            value++;
        }
    }
    public void dec(){
        synchronized(this){
            value--;
        }
    }
}

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter1();
        for(int i=0;i<10000;i++){
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<1000;i++){
                        counter.inc();
                    }
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<1000;i++){
                        counter.dec();
                    }
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            if(counter.get()!=0)
                System.out.println("Value: " + counter.get());
        }
    }
}