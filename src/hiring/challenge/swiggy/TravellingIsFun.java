package hiring.challenge.swiggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by asaxena on 9/13/2018.
 * Problem: Travelling is fun - HackerEarth
 */
public class TravellingIsFun {

    static boolean[][] path,visited;

    static int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static boolean getIndirectPath(int n, int start, int end){

        if(visited[start][end])
            return false;

        visited[start][end]=true;

        if(path[start][end])
            return true;

        for(int j=0;j<n;j++){
            if(path[start][j] && getIndirectPath(n,j,end)) {
                path[start][end] = path[end][start] = true;
                return true;
            }
        }
        path[start][end] = path[end][start] = false;
        return false;
    }
    static void setDirectPath(int n, int g){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                path[i][j]=path[j][i]=(i==j || gcd(i+1,j+1)>g);
            }
        }
    }

    static int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {
        // Write your code here
        int[] result = new int[originCities.length];

        for(int i=0;i<originCities.length;i++){
            visited = new boolean[n][n];
            if(getIndirectPath(n,originCities[i] -1,destinationCities[i]-1))
                result[i]=(1);
            else
                result[i]=(0);
        }
        return result;
    }

    public static void main(String[] args) {

        int n=6;
        int g=0;
/*
        int[] origin = {1,4,3,6};
        int[] destin = {3,6,2,5};


        //System.out.println(Arrays.deepToString(path));
        int[] result = connectedCities(n,g,origin,destin);
        System.out.println(Arrays.toString(result));
        //System.out.println(Arrays.deepToString(path));
*/

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        g = in.nextInt();
        path=new boolean[n][n];

        setDirectPath(n,g);
        int originCities_cnt = in.nextInt();
        int[] originCities = new int[originCities_cnt];
        for(int originCities_i = 0; originCities_i < originCities_cnt; originCities_i++){
            originCities[originCities_i] = in.nextInt();
        }
        int destinationCities_cnt = in.nextInt();
        int[] destinationCities = new int[destinationCities_cnt];
        for(int destinationCities_i = 0; destinationCities_i < destinationCities_cnt; destinationCities_i++){
            destinationCities[destinationCities_i] = in.nextInt();
        }

        int[] res = connectedCities(n, g, originCities, destinationCities);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + (i != res.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
