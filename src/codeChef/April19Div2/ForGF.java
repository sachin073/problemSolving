package codeChef.April19Div2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sachin on 9/4/19.
 *
 *
 *
 Shlok and Sachin are good friends. Shlok wanted to test Sachin, so he wrote down a string S with length N and one character X. He wants Sachin to find the number of different substrings of S which contain the character X at least once. Sachin is busy with his girlfriend, so he needs you to find the answer.

 Two substrings of S are considered different if their positions in S are different.

 Input
 The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
 The first line of each test case contains a single integer N.
 The second line contains a string S with length N, followed by a space and a character X.
 Output
 For each test case, print a single line containing one integer — the number of substrings of S that contain X.

 Constraints
 1≤T≤1,000
 1≤N≤106
 S contains only lowercase English letters
 X is a lowercase English letter
 the sum of N over all test cases does not exceed 106
 Subtasks
 Subtask #1 (30 points): the sum of N over all test cases does not exceed 103
 Subtask #2 (70 points): original constraints

 Example Input
 2
 3
 abb b
 6
 abcabc c
 Example Output
 5
 15


 ###very fast if less no. of occurences but with higher need some optimization
 */
public class ForGF {


    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new FileReader(new File("src/input.in")));

        int test = Integer.parseInt(reader.readLine());

        while (test>0){
            int length = Integer.parseInt(reader.readLine());
            String inp =reader.readLine();
            char array[] =inp.split(" ")[0].toCharArray();
            char letter = inp.split(" ")[1].charAt(0);
            int size = array.length;
            List<Integer> indexes = new ArrayList<>();

            for (int i = 0; i <length; i++) {
                if (letter==array[i]){
                    indexes.add(i);
                }
            }

            int counter=0;

            int lastJump= 0;
            for (int i = 0; i <size; i++) {
                boolean jumpSucced=true;
                for (int j = i; j <size; j++) {

                    int jump=-1;
                    for (int k = lastJump; k < indexes.size() ; k++) {

                        if (indexes.get(k) >= j){
                            jump=indexes.get(k);
                            lastJump=k;
                            break;
                        }

                    }

                    if (jump==-1){//no near place ahead
                        jumpSucced=false;
                        break;
                    }
                    counter = counter + (size-jump);
                    break;
                }
                if (!jumpSucced)
                    break;
            }

            System.out.println(counter);
            test--;
        }

    }

    static int arrayJump(List<Integer> array,int number,Integer lastJump){

        for (int i = lastJump; i < array.size() ; i++) {
             lastJump=new Integer(i);
            if (array.get(i) >=number)
                return array.get(i);

        }

/*
        for (Integer i : array) {
            if (i>=number)
                return i;
        }
*/

        return -1;
    }


}
