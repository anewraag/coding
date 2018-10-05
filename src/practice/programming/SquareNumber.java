package practice.programming;

import java.math.BigInteger;

/**
 * Created by asaxena on 9/19/2018.
 */

public class SquareNumber {
    public static long g4gSquare(long n){
        // Base case
        if (n == 0)
            return 0;

        // Handle negative number
        if (n < 0)
            n = -n;

        // Get floor(n/2) using
        // right shift
        long x = n >> 1;

        if (n % 2 == 0)
            return (g4gSquare(x) << 2);
        else // If n is even
            return ((g4gSquare(x) << 2) + (x << 2) + 1);

    }

    public static long mySquare(long n){
        if(n==0) return 0;
        long x = n >> 1;
        if(n%2==0)
            return (mySquare(x) << 2);
        else{
            return ((mySquare(x) << 2) + (x << 2) + 1);
        }
    }

    public static long power(int a, int b){
        // returns a^b

        if(a==0 || b==1)  return a;
        else if(b%2==0)
            return mySquare(power(a,b/2));
        else{
            return mySquare(power(a,b/2))*a;
        }
    }

    public static void main(String[] args) {
        int n =5;
        System.out.println(power(n,n));
    }
}
