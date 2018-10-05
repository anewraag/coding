package practice.dp;

import java.util.Arrays;

/**
 * Created by asaxena on 9/3/2018.
 */
public class CoinChange {

    public static long count(int[] S, int m, int n ){
        if(n==0) return 1;
        if(n<0) return 0;
        if(m<=0 && n>=1) return 0;
        return count(S,m-1,n) + count(S,m,n-S[m-1]);
    }

    public static long countDP(int[] S, int m, int n){
        long table[]= new long[n+1];
        Arrays.fill(table,0);
        table[0]=1;
        for(int i=0;i<m;i++){
            for(int j=S[i];j<=n;j++){
                table[j]+=table[j-S[i]];
            }
        }
        return table[n];
    }

    public static void main(String[] args) {
        int[] denominations = {1,2,3};
        int sum =4;
        System.out.println("Answer: " + count(denominations,denominations.length,sum));
        System.out.println("Answer: " + countDP(denominations,denominations.length,sum));
    }
}
