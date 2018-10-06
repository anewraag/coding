package practice.programming;

import java.util.Scanner;

/**
 * Created by asaxena on 10/21/2016.
 * Question: https://www.hackerearth.com/practice/math/combinatorics/basics-of-combinatorics/practice-problems/algorithm/velma-and-triplets/
 */
public class VelmaAndTriplets {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(),x;
        long a1=0,a2=0,a3=0,ans=0;
        for (int i = 0; i < N; i++) {
            x=s.nextInt();
            if(x==1)a1++;
            if(x==2)a2++;
            if(x==3)a3++;
        }
        ans=(a1*(a1-1)*(a1-2)/2)+a1*(a1-1)*a2+(a1*(a1-1)*(N-a1-a2)/2)+(a2*(a2-1)*a1/2)+a1*a2*a3;
        System.out.println(ans);
    }
}
