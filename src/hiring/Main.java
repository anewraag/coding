package hiring;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    boolean[] primes=new boolean[1000000];
    //set up the primesieve
    public void fillSieve() {
        Arrays.fill(primes,true);        // assume all integers are prime.
        primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.
        for (int i=2;i<primes.length;i++) {
            //if the number is prime,
            //then go through all its multiples and make their values false.
            if(primes[i]) {
                for (int j=2;i*j<primes.length;j++) {
                    primes[i*j]=false;
                }
            }
        }
    }
    public static void main(String args[] ) throws Exception {

        Main obj = new Main();
        obj.fillSieve();
        ArrayList<Integer> safeStreet = new ArrayList();
        ArrayList<Integer> response = new ArrayList();
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 1; i <= N; i++) {
            Integer streetVal=s.nextInt();
            if(obj.primes[streetVal]) {
                safeStreet.add(i);
                System.out.println(streetVal);
            }
        }
        int start =0;
        System.out.println("Hello World!");
    }
}
