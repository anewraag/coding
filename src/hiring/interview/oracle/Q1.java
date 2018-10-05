package hiring.interview.oracle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asaxena on 9/17/2018.
 */
public class Q1 {
    static Character getFirst(String str){

        Character result=null;
        Map<Character,Integer> occurenceMap = new HashMap<>();

        for(int i=0;i<str.length();i++){

            if(occurenceMap.containsKey(str.charAt(i)))
                occurenceMap.put(str.charAt(i),occurenceMap.get(str.charAt(i))+1);
            else {
                occurenceMap.put(str.charAt(i), 1);
            }
        }

        for(int i=0;i<str.length();i++){
            if(occurenceMap.get(str.charAt(i))==1)
                result =  str.charAt(i);
        }
        return result;

    }
    public static void main(String[] args) {
        System.out.println("Answer: " + getFirst("ab"));
    }
}
