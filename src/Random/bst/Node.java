package Random.bst;

import java.util.Comparator;

/**
 * Created by sachin on 25/4/19.
 */
public class Node implements Comparator<Integer>{
    // Field to create comparision and also the actual valuable data
    int value;

    Node left=null;
    Node right=null;

    public Node(int value) {
        this.value = value;
    }


    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1,o2);
    }

    @Override
    public boolean equals(Object obj) {
        return value==((Node)obj).value;
    }

    @Override
    public String toString() {
        return value+"";
    }
}
