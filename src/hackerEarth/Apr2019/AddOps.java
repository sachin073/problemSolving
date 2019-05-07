package hackerEarth.Apr2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachin on 5/5/19.
 *
 *
 Add Operator and Fraction

 You are given two fractions: 0/1 and 1/2.
 In each step, you will get two adjacent fractions and you need to add them,
 if and only if, the denominator is equal to or smaller than the number obtained in that step
 and write it between those two adjacent fractions.

 Example:

 Step 1: 0/1,1/2

 Step 2: 0/1,1/2

 Step 3: 0/1,1/3,1/2 and so on

 The add operator is defined as follows:

 If (a/b) and (c/d) is added, then the sum is (a+c)/(b+d) which means
 that their numerators and denominators both are added to each other.

 You have to find the kth fraction in the nth step.

 Note: You will be given the values of n and k

 Input format

 First line: Two integers n and k (1<n<=100000 ) where n is the number of steps.
 It is guaranteed that there is at least k numbers written in nth step.

 Output format

 Print the answer in the format (int)/(int), like 3/5.

 SAMPLE INPUT
 5 5
 SAMPLE OUTPUT
 2/5

 */
public class AddOps {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


   static int steps=0,idx=0;

   public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new FileReader(new File("src/input.in")));

        String inp= reader.readLine();
       steps = Integer.parseInt(inp.split(" ")[0]);
       idx= Integer.parseInt(inp.split(" ")[1]);

       Integer num[]= {0,1};
       Integer deno[]={1,2};
        int step=3;
       while (steps>=step){


           List<Integer> alNum =new ArrayList<Integer>();
           List<Integer> aldeno =new ArrayList<Integer>();
           //start i from 0 and j from next, till any number in array
           for (int i = 0,j=1; i < num.length && j< num.length; i++,j++) {

               if (deno[i]+deno[j] <=step){
                    alNum.add(num[i]);
                    alNum.add(num[i]+num[j]);

                    aldeno.add(deno[i]);
                    aldeno.add(deno[i] + deno[j]);
               }else {
                   alNum.add(num[i]);

                   aldeno.add(deno[i]);
               }
           }
           alNum.add(num[num.length-1]);
           aldeno.add(deno[num.length-1]);

            num = new Integer[alNum.size()];
            num = alNum.toArray(num);
            deno =new Integer[alNum.size()];
           deno = aldeno.toArray(deno);

           step++;
       }
       System.out.println(num[idx-1]+"/"+deno[idx-1]);


   }

}

