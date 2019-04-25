package Random.tries;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sachin on 23/4/19.
 */
public class TrieNode {
    Map<Character,TrieNode> container = new LinkedHashMap<>();

    final Character data ;

    boolean isWord;

    public TrieNode(Character data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "container=" + container +
                ", data=" + data +
                ", isWord=" + isWord +
                '}';
    }


    public TrieNode addLetter(Character character,boolean isWord){
        TrieNode node = new TrieNode(character);
        container.put(character,node);
        if (isWord){
            node.isWord=isWord;
        }
        return node;
    }

    public boolean containLetter(Character character){
        return container.containsKey(character);
    }



}
