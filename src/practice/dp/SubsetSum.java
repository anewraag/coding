package practice.dp;

import practice.templates.ArrayHelper;

import java.util.Objects;

/**
 * Created by asaxena on 9/30/2018.
 * Question: https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 */
public class SubsetSum {
    public static boolean isSumPresent(int[] set, int n , int sum){
        if(n==0 && sum!=0) return false;
        else if(sum==0) return true;
        else return isSumPresent(set,n-1,sum-set[n-1]) || isSumPresent(set,n-1,sum);
    }
    public static boolean isSumPresentDP(int[] set, int n , int sum){
        Boolean table[][] = new Boolean[n+1][sum+1];

        //initializing the table
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0 && j!=0) table[i][j]=false;
                else if(j==0) table[i][j]=true;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                table[i][j] = table[i-1][j];
                if(j-set[i-1]>=0)
                    table[i][j] = table[i][j]|| table[i-1][j-set[i-1]];
            }
        }
        ArrayHelper.print2dArray(table,n+1,sum+1);
        return table[n][sum];
    }
    public static long countSubset(int[] set, int n , int sum){
        if(n==0 && sum!=0) return 0;
        else if(sum==0) return 1;
        else return countSubset(set,n-1,sum-set[n-1]) + countSubset(set,n-1,sum);
    }
    public static long countSubsetDP(int[] set, int n , int sum){
        Long table[][]=new Long[n+1][sum+1];

        //initialize the table
        for(int i=0;i<=n;i++)
            table[i][0]=1L;
        for(int j=1;j<=sum;j++)
            table[0][j]=0L;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                table[i][j]=table[i-1][j];
                if(j-set[i-1]>=0)
                    table[i][j]+=table[i-1][j-set[i-1]];
            }
        }
        ArrayHelper.print2dArray(table,n+1,sum+1);
        return table[n][sum];
    }
    public static String printSubsets(int[] set, int n , int sum){
        return null;
    }
    public static void main(String[] args) {
        int set[] = {2,1,8,9,10};
        int sum = 10;
        System.out.println(isSumPresent(set,set.length,sum));
        System.out.println(isSumPresentDP(set,set.length,sum));
        System.out.println(countSubset(set,set.length,sum));
        System.out.println(countSubsetDP(set,set.length,sum));
    }
}
