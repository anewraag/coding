package hiring.interview.oracle;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by asaxena on 9/17/2018.
 */
public class Q2 {
    static Integer getKlargest(int[] arr,int k){

        Integer answer=0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for(int i=0;i<arr.length;i++){
            priorityQueue.add(arr[i]);
        }

        Iterator iterator = priorityQueue.iterator();

        int cnt=0;
        while(iterator.hasNext() && cnt!=k){

            answer = priorityQueue.poll();
            cnt++;

        }

        return answer;
    }
    public static void main(String[] args) {

    }
}
