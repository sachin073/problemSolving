package Random.bst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by sachin on 25/4/19.
 */
public class BstImpl {


    static Node root =new Node(0);

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new FileReader(new File("src/input.in")));

        BstImpl bst = new BstImpl();
        bst.addNode(new Node(50));
        bst.addNode(new Node(30));
        bst.addNode(new Node(20));
        bst.addNode(new Node(40));
        bst.addNode(new Node(70));
        bst.addNode(new Node(60));
        bst.addNode(new Node(80));

        bst.printBST(root);
    }



    public void addNode(Node node){
        addNode(node,root);
    }

    public void addNode(Node node,Node currentLoc){
        if (currentLoc.value < node.value){
            if (currentLoc.right==null){
                currentLoc.right=node;
            }else {
                addNode(node,currentLoc.right);
            }

        }else {
            if (currentLoc.left==null){
                currentLoc.left=node;
            }else {
                addNode(node,currentLoc.left);
            }
        }
    }

    /**
     *
     * Sorted inorder mean a perfect BST
     * */
    public void printBST(Node node){

        if (node.left!=null){
            printBST(node.left);
        }
        System.out.print(node.value);

        if (node.right!=null){
            printBST(node.right);
        }


    }


}
