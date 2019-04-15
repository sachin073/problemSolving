package codeChef.April19Div2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by sachin on 8/4/19.
 *
 * Maximum Remaining
 *
 * The puzzle contains an integer sequence A1,A2,…,AN.
 * The answer to the puzzle is the maximum of Ai%Aj, taken over all valid i, j.


 todo make it faster to support 10^5 size array under 1sec

 *
 */
public class MaxRem {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        reader = new BufferedReader(new FileReader("src/input.in"));
        int size = Integer.parseInt(reader.readLine());
        int[] ar= new int[size];
        String string = reader.readLine();

        int i=0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String s :string.split(" ")) {
                ar[i]=Integer.parseInt(s);
                maxHeap.add(ar[i]);
                i++;
        }
        int max=0;
        for (i = 0; i < size; i++) {
//            int mod = ar[i] % maxHeap.peek();

            int mod = ar[i] & (maxHeap.peek()-1);
            if (mod > max){
                max =mod;
            }

            maxHeap.remove(ar[i]);
        }

        System.out.println(max);

    }

}

