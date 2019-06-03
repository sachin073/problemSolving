package GFG.dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by sachin on 2/6/19.
 *
 *0-1 Knapsack Problem | DP-10
 Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 Also given an integer W which represents knapsack capacity,
 find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


 int val[] = new int[]{60, 100, 120};
 int wt[] = new int[]{10, 20, 30};

 Output:
 220

 */
public class KnapSack {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
       // reader = new BufferedReader(new FileReader(new File("src/input.in")));

        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int bagCapacity = 50;
        System.out.println(maxTheft(val,wt,bagCapacity));
    }



    static int max(int a,int b){
        return a>b?a:b;
    }


    static int maxTheft(int[] vals,int[] weights,int bagCapacity){


        //array of size DP[val.length][capacity]
        int[][] dp = new int[vals.length+1][bagCapacity+1];

        for (int i = 0; i <=vals.length; i++) {
            for (int j = 0; j <=bagCapacity; j++) {

                if (i==0 || j==0){
                    dp[i][j]=0;
                    continue;
                }
                if (weights[i-1]==j){
                    dp[i][j]=max(vals[i-1],dp[i-1][j]);
                }else if (weights[i-1]<j){
                    dp[i][j]=max(vals[i-1]+dp[i-1][j-weights[i-1]] , dp[i-1][j]);
                }else { //w >j
                    dp[i][j]=dp[i-1][j];
                }

            }
        }
        return dp[vals.length][bagCapacity];
    }








}
