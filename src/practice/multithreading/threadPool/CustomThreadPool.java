package practice.multithreading.threadPool;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by asaxena on 8/28/2018.
 */
interface BlockingQueueCustom<E> {

    void put(E item) throws InterruptedException;
    E take() throws InterruptedException;
    int size();

}
class LinkedBlockingQueueCustom<E> implements BlockingQueueCustom<E>{

    private List<E> queue;
    private int maxSize;

    public LinkedBlockingQueueCustom(int maxSize){
        this.queue = new LinkedList<E>();
        this.maxSize = maxSize;
    }

    @Override
    public synchronized void put(E item) throws InterruptedException {
        if(queue.size()==maxSize)
            this.wait();

        queue.add(item);
        this.notifyAll();
    }

    @Override
    public E take() throws InterruptedException {
        if(queue.isEmpty())
            this.wait();
        this.notifyAll();
        return queue.remove(0);
    }

    @Override
    public synchronized int size() {
        return queue.size();
    }
}
class ThreadPoolCustom {
    private BlockingQueueCustom<Runnable> taskQueue;

    public ThreadPoolCustom(int nThreads){
        for(int i=0;i<nThreads;i++){
            /*Start nThreads*/
        }
    }
    public BlockingQueueCustom<Runnable> taskQueue(){
        return taskQueue;
    }
    public synchronized void execute(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }
}
class ThreadCustom extends Thread{
    ThreadPoolCustom threadPool;

    public void run(){
        while(true){
            Runnable task = null;
            try {
                task = threadPool.taskQueue().take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            task.run();
        }
    }
}
