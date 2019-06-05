package GFG.dp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sachin on 5/6/19.
 *
 * borrowed and reference video desc
 * Tushar roy coin change
 * Back to SWE coin change problems
 *
 */
public class CoinChange {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        //reader = new BufferedReader(new FileReader(new File("src/input.in")));

        int[] coins={1,5,2};
        int sum = 5;

        int ways=waysToSum(coins,sum);

        System.out.println("Number of Ways to change "+ways);
        int noMinCoinsUsed=minCoinsNeeded(coins,sum);

        System.out.println("Number of coins needed "+noMinCoinsUsed);
    }


    static int waysToSum(int[] coins, int sum){

        int ways;

         // table contains ways to change
        int dp[][] =new int[coins.length+1][sum+1];

        for (int i = 1; i <= coins.length; i++) {//row be coins
            for (int j = 0; j <= sum; j++) {// columns is sum to be made

                // if summ is 0 then there is one way, no change
                if (j==0){
                    dp[i][j]=1;
                    continue;
                }

                if (coins[i-1]>j){

                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }

            }
        }

        print2DArray(dp);
        ways=dp[coins.length][sum];
        return ways;
    }

    private static void print2DArray(int[][] dp) {
        for (int[] x:
             dp) {
            System.out.println(Arrays.toString(x));
        }
    }

    static int minCoinsNeeded(int[] coins,int sum){
        int minCoinsUsed;

        int dp[][] = new int[coins.length+1][sum+1];

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= sum; j++) {

                if (coins[i-1]>j){
                    // not choose c[i-1] coin,
                    // then min coin used is building sum is coin used till coins[i-1-1]
                    dp[i][j]=dp[i-1][j];
                }else if (j >= coins[i-1]){
                    // choose c[i-1] coin,
                    // then min coin used is building sum is
                    // min of (coin used till coins[i-1-1] to build sum, coins used to build sum-coin[i] +1(this coin) )
                    if (dp[i-1][j] !=0)
                        dp[i][j]= Integer.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                    else
                        dp[i][j]= dp[i][j-1]+1;
                }
            }
        }

        print2DArray(dp);

        minCoinsUsed = dp[coins.length][sum];

        return minCoinsUsed;
    }


}
