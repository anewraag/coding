package hiring.interview.halodoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by asaxena on 10/10/2018.
 * Ques: Divisibility Check
 */

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        String[] inp = br.readLine().split(" ");
        for(int i=0;i<N;i++)
        {
            A[i] = Integer.parseInt(inp[i]);
        }
        int out_ = solve(N, A);
        System.out.println(out_);
        wr.close();
        br.close();
    }
    static int solve(int N, int[] A){
        int ans=0;
        HashMap<Integer,Integer> map = new HashMap();

        for(int i=0;i<N;i++){
            if(map.containsKey(A[i]))
                map.put(A[i],map.get(A[i])+1);
            else
                map.put(A[i],1);
        }
        Integer oneCount = map.get(1);
        if(oneCount!=null) {
            if (oneCount == 1) ans = N - 1;
            else if (oneCount == 2)ans = N;
        }
        else{
            for(int i=0;i<N;i++){
                for (int j=2; j<=Math.sqrt(A[i]); j++){
                    if (A[i]%j==0 && (map.containsKey(A[i]/j) || map.containsKey(j))) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
