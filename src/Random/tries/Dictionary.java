package Random.tries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sachin on 23/4/19.
 */
public class Dictionary {


    final static TrieNode root = new TrieNode(' ');

    public void addWord(String word){
        TrieNode tempNode=root;
        char[] chars = word.toCharArray();
        for (int i = 0; i <chars.length; i++) {
            if (tempNode.containLetter(chars[i])){
                tempNode = tempNode.container.get(chars[i]);
            }else{
                tempNode = tempNode.addLetter(chars[i],i==chars.length-1);
            }
        }
    }

    public boolean containsWord(String word){
        System.out.println("checking exists:  "+word);
        TrieNode tempNode=root;
        char[] chars = word.toCharArray();
        for (int i = 0; i <chars.length; i++) {
            if (tempNode.containLetter(chars[i])){
                tempNode = tempNode.container.get(chars[i]);
            }else{
               return false;
            }
        }
        System.out.println(tempNode.isWord);
        return tempNode.isWord;
    }


    public void printDictionary(TrieNode node, Stack<Character> characterStack){

        for (Map.Entry<Character,TrieNode> entry: node.container.entrySet()) {
            characterStack.push(entry.getKey());
            printDictionary(entry.getValue(),characterStack);

        }
        if (node.isWord){
            System.out.println(characterStack);
        }
        if (!characterStack.empty())
            characterStack.pop();

    }





    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new FileReader(new File("src/input.in")));
        Dictionary dictionary = new Dictionary();
        dictionary.addWord(reader.readLine());
        dictionary.addWord(reader.readLine());
        dictionary.addWord(reader.readLine());
        dictionary.addWord(reader.readLine());

        dictionary.printDictionary(Dictionary.root,new Stack<>());
        dictionary.containsWord("sss");
    }

}
