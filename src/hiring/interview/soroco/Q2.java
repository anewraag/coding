package hiring.interview.soroco;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by asaxena on 9/3/2018.
 */
public class Q2 {
    static int CountNaturalNumber(int n){

        int cnt=0;
        for(int i=1;i<=n;i++){
            int[] numCache = new int[10];
            Arrays.fill(numCache,0);
            String num = Integer.toString(i);
            for(int j=0;j<num.length();j++){
                numCache[num.charAt(j)-'0']+=1;
            }
            int sortedNum=0;
            for(int j=0;j<10;j++){
                while(numCache[j]!=0) {
                    sortedNum += 10 * sortedNum + j;
                    numCache[j]--;
                }
            }
            if(sortedNum>=i)
                cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            System.out.println("Cnt:" + CountNaturalNumber(n));
        }
    }
}
