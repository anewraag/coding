package hiring.interview.soroco;

import java.util.Arrays;
import java.util.List;

/**
 * Created by asaxena on 9/3/2018.
 */
public class Q3 {
    static int maximum_cookies(List<Integer> jars) {
        int in = jars.get(0),out = 0,maxOut;
        for(int i = 1; i < jars.size(); i++){
            maxOut = (in > out) ? in : out;
            in = out + jars.get(i);
            out = maxOut;
        }
        return in>out?in:out;
    }

    static int FindMaxSum(int arr[], int n)
    {
        int incl = arr[0],excl = 0,maxOut;
        for (int i = 1; i < n; i++){
            maxOut = (incl > excl) ? incl : excl;
            incl = excl + arr[i];
            excl = maxOut;
        }

		/* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        List<Integer> jars = Arrays.asList(10,20,30,10);
        System.out.println(maximum_cookies(jars));

        int arr[] = new int[]{10,20,30,10};
        System.out.println(FindMaxSum(arr, arr.length));
    }
}
