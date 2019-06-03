package GFG.dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by sachin on 14/5/19.
 *
 *
 * Given a set of non-negative integers,
 * and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 *
 * Also print number which make sum possible
 *
 *  Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
    Output:  True  //There is a subset (4, 5) with sum 9.
 *
 *
 *
 *
 */
public class SubsetSum {


    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new FileReader(new File("src/input.in")));

        ArrayList<Integer> intList = new ArrayList<>();
        // delimiter \t \r \f space, used for fast reading
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreElements()){
            intList.add(Integer.parseInt(tokenizer.nextToken()));
        }
        Integer [] arr = new Integer[intList.size()];

        arr=  intList.toArray(arr);
        fillDP(arr,Integer.parseInt(reader.readLine()));
        System.out.println("data >> "+ Arrays.toString(arr));

    }


    static boolean dp[][]=null;
    static void fillDP(Integer[] arr,int sum){
        dp= new boolean[sum+1][arr.length];

        /*
        DP , row of sum and column of array number
            num -->
          0 2 1 5 3
  SUM   0 T T T T T
   |    1 f
   |    2 f
   v    3 f
        4 f
        logic,
        so , if
              1.  sum == NUM then put true
              2.   sum > Num  then i.e you have decided to take that number for sum,
                    so, go UP step N and in previous column
              3.  Num > sum then  copy  from left

           video tut, reverse this so, logic also reverse
           https://www.youtube.com/watch?v=s6FhG--P7z0&t=318s

                */

        // first row all true
        for (int i = 0; i < arr.length; i++) {
            dp[0][i]=true;
        }


        // first column all false
        for (int i = 1; i <= sum; i++) {
            dp[i][0]=false;
        }

        for (int i = 1; i < sum+1; i++) {
            for (int j = 1; j < arr.length; j++) {

                if (i == (int) arr[j] ){
                    dp[i][j] = true;
                }else if (i > arr[j]){
                    dp[i][j] = dp[i - 1][j];
                    if (i>arr[j] && j>0) {
                        dp[i][j] = dp[i - arr[j]][j - 1];
                    }
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

            }

        for (int i = 0; i < sum+1; i++) {
            System.out.println(i+">> "+Arrays.toString(dp[i]));
        }
    }



    }