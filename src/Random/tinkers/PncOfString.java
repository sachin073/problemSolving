package Random.tinkers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PncOfString {



    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String pnc = reader.readLine();

        char[] pncAr= pnc.toCharArray();
        int freez=0;
        int swap=0;
        printPnc(pncAr,freez);
    }



    static void printPnc(char[] string,int freezeIndex){

        if (freezeIndex==string.length-1){
            System.out.println(string);
        }else {
            for (int i = freezeIndex; i <string.length ; i++) {
                swap(string,freezeIndex,i);
                printPnc(string,freezeIndex+1);
                swap(string,freezeIndex,i);
            }
        }

    }

    private static void swap(char[] string, int freezedIndex, int swapIndex) {
        char temp = string[freezedIndex];
        string[freezedIndex] = string[swapIndex];
        string[swapIndex]=temp;
    }
}
