package hiring.interview.soroco;

import java.util.*;

/**
 * Created by asaxena on 9/5/2018.
 */
public class Q4 {
    /*
    * {"abc","bcd","acef","xyz","az","ba","a","z","rft"}
    * Output:
    *   {{"abc","bcd","xyz"}{"rft"},{"acef"},{"a","z"},{"az","ba"}}
    * */

    public static String getCSVString(String str){
        String csvStr="";

        for(int i=0;i<str.length()-1;i++){
            int diff=(str.charAt(i+1)-str.charAt(i));
            if(diff<0){
               diff=26+diff;
            }
            csvStr+=diff+",";
        }
        return csvStr;
    }
    public static Map groupedStrings(List<String> listStr){

        Map<String,List<String>> map = new HashMap<>();

        //traversing through the list to get the comma separated string
        for(int curStr=0;curStr<listStr.size();curStr++){
            String key="";
            if(listStr.get(curStr).length()==1)
                key="0";
            else{
                key=getCSVString(listStr.get(curStr));
            }
            if(map.containsKey(key))
                map.get(key).add(listStr.get(curStr));
            else {
                List<String> initialList = new ArrayList<>();
                initialList.add(listStr.get(curStr));
                map.put(key,initialList);
            }
        }
        return map;
    }
    public static void printGroups(Map<String,List<String>> groupedMap){
        for(String key: groupedMap.keySet()){
            List<String> group = groupedMap.get(key);
            for(int i=0;i<group.size();i++){
                System.out.print(group.get(i)+" ");
            }
            System.out.println();
        }
        System.out.println("Group Count: "+ groupedMap.size());
        System.out.println();
        System.out.println();
    }
    public static void main(String[] args) {

        printGroups(groupedStrings(
                Arrays.asList("abc","bcd","acef","xyz","az","ba","a","z","rft")));

        printGroups(groupedStrings(
                Arrays.asList("a", "c", "d", "z", "bd", "gi", "km", "bc", "cd", "pq", "gil", "qsv", "mor", "acegikm", "bdfhjln", "adgjmq", "behknr", "ampq")));

    }
}
