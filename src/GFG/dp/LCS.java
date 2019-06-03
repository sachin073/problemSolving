package GFG.dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sachin on 3/6/19.
 */
public class LCS {


    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new FileReader(new File("src/input.in")));

        String first="abcdaf";//"master maker";
        String second="acbcf";//"learner maker";

        int[][] dp = commonSeqDP(first,second);

        for (int[] x :
                dp) {
            System.out.println(Arrays.toString(x));
        }

        System.out.println("\nLCS is "+dp[first.length()][second.length()]);

    }



    static int[][] commonSeqDP(String first ,String second){


        char[] ff= (first).toCharArray();
        char[] sec = (second).toCharArray();

        int[][] dp =new int[ff.length+1][sec.length+1];

        for (int i = 1; i <=ff.length; i++) {
            for (int j = 1; j <= sec.length; j++) {


                if (ff[i-1]==sec[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Integer.max(dp[i][j-1],dp[i-1][j]) ;
                }
            }
        }

        return dp;
    }

}
