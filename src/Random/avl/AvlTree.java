package Random.avl;

import Random.bst.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by sachin on 7/5/19.
 */
public class AvlTree {


    Node root ;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new FileReader(new File("src/input.in")));
        AvlTree tree = new AvlTree();
        tree.root = tree.addNode(tree.root,10);
        tree.root = tree.addNode(tree.root,20);
        tree.root = tree.addNode(tree.root,30);
        tree.root = tree.addNode(tree.root,40);
        tree.root = tree.addNode(tree.root,50);
        tree.root = tree.addNode(tree.root,25);

        tree.printBST(tree.root);
        System.out.println("\n\n");
        tree.printBST(tree.root);

    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value+ " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    public void printBST(Node node){

        if (node.left!=null){
            printBST(node.left);
        }
        System.out.print(node.value);

        if (node.right!=null){
            printBST(node.right);
        }


    }

    int maxHeight(Node left,Node right){
      return height(left) > height(right)?left.height:right.height;
    }

    Node addNode(Node node,int key){

        if (node==null){
            return new Node(key,0);
        }else if (key < node.value){
            node.left=addNode(node.left,key);
        }else if (key > node.value){
           node.right=addNode(node.right,key);
        }else
            return node;

        node.height = 1+ maxHeight(node.left,node.right);

        //if balance >1 or <0
        int balance = getBalance(node.left,node.right);


        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.value)
            return rightRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.value)
            return leftRotate(node);


        // Right Left Case
        if (balance < -1 && key < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    private Node rightRotate(Node node) {
        Node z = node;
        Node y = node.left;
        Node T2 = y.right;

        //rotation
        y.right=z;
        z.left = T2;
        z.height = maxHeight(z.left, z.right) + 1;

        y.height = maxHeight(y.left, y.right) + 1;

        return node;
    }

    private Node leftRotate(Node node) {
        Node z = node;
        Node y = node.right;

        Node T2 = node.left;

        //rotation
        y.left=z;
        z.right = T2;

        y.height = maxHeight(z.left, z.right) + 1;

        z.height = maxHeight(y.left, y.right) + 1;


        return node;
    }



    int height(Node node){
        return node!=null?node.height:0;
    }

    private int getBalance(Node left, Node right) {

        return height(left)-height(right);
    }


}
