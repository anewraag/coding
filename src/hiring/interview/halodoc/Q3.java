package hiring.interview.halodoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * Created by asaxena on 10/10/2018.
 */
public class Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int k = Integer.parseInt(temp[1]);
            String S = br.readLine().trim();
            String out_ = Solution(n,k,S);
            System.out.println(out_);
        }
        wr.close();
        br.close();
    }
    static String Solution(int N,int K,String S){
        // Write your code here

        BigInteger maxXorVal=BigInteger.valueOf(Integer.MIN_VALUE),currXorVal,prevXorVal=BigInteger.valueOf(0);
        BigInteger maxSubNum=BigInteger.valueOf(Integer.MIN_VALUE),currSubNum;

        for(int i=1;i<N;i++){
            currSubNum = BigInteger.valueOf(Integer.parseInt(S.substring(i)));
            currXorVal = prevXorVal.xor(BigInteger.valueOf(S.charAt(i-1)-'0')) ;
            if(currSubNum.mod(BigInteger.valueOf(K)).equals(BigInteger.valueOf(0))){
                if(currXorVal.compareTo(maxXorVal)>0 || (currXorVal==maxXorVal && currSubNum.compareTo(maxSubNum)>0)){
                    maxSubNum=currSubNum;
                    maxXorVal=currXorVal;
                }
            }
            prevXorVal=currXorVal;
        }
        return Integer.toString(maxSubNum.intValue());
    }
}
