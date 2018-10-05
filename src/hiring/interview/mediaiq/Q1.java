package hiring.interview.mediaiq;

import java.util.*;

/**
 * Created by asaxena on 9/4/2018.
 */
public class Q1 {
    static int getHeight(List<Integer> predators,int size, int index){
        // Find all index where given index is present
        int height=0;
        for(int i=0;i<size;i++){
            if(predators.get(i)==index)
                height= 1+Math.max(height,getHeight(predators,size,i));
        }
        return height;
    }

    public static int maximumGroups(List<Integer> predators) {
        int groups=0;
       for(int i=0;i<predators.size();i++){
           if(predators.get(i)==-1){
               groups=Math.max(groups,getHeight(predators,predators.size(),i));
           }
       }
        return groups+1;
    }

    public static void main(String[] args) {
        int[] list= {-1,8,6,0,7,3,8,9,-1,6};
        List<Integer> predators= new ArrayList<>();
        for(int i=0;i<list.length;i++){
            predators.add(list[i]);
        }
    }
}
