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
        /*System.out.println("adding key"+10);
        tree.root = tree.addNode(tree.root,10);
        System.out.println("adding key"+20);
        tree.root = tree.addNode(tree.root,20);
        System.out.println("adding key"+30);
        tree.root = tree.addNode(tree.root,30);
        System.out.println("adding key"+40);
        tree.root = tree.addNode(tree.root,40);
        System.out.println("adding key"+50);
        tree.root = tree.addNode(tree.root,50);
        System.out.println("adding key"+25);
        tree.root = tree.addNode(tree.root,25);
*/


        tree.root = tree.addNode(tree.root, 9);
        tree.root = tree.addNode(tree.root, 5);
        tree.root = tree.addNode(tree.root, 10);
        tree.root = tree.addNode(tree.root, 0);
        tree.root = tree.addNode(tree.root, 6);
        tree.root = tree.addNode(tree.root, 11);
        tree.root = tree.addNode(tree.root, -1);
        tree.root = tree.addNode(tree.root, 1);
        tree.root = tree.addNode(tree.root, 2);

        tree.printBST(tree.root);
        System.out.println("\n\n");
        tree.root=tree.deleteNode(tree.root,10);
        tree.printBST(tree.root);
tree.preOrder(tree.root);
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

    int maxHeight(Node node){
        if (node == null|| (node.left==null && node.right==null)){
            return 0;
        }
      return height(node.left) > height(node.right)?node.left.height:node.right.height;
    }

    Node addNode(Node node,int key){
        System.out.println("calling for node"+node+" key"+key);

        if (node==null){
            return new Node(key,1);
        }else if (key < node.value){
            node.left=addNode(node.left,key);
        }else if (key > node.value){
           node.right=addNode(node.right,key);
        }else
            return node;

        node.height = 1 + maxHeight(node);
        System.out.println("cal new height for node"+node+" key "+ key);

        //if balance >1 or <0
        int balance = getBalance(node.left,node.right);

        System.out.println("balance of node"+node+" balance "+balance);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.value)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.value)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

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
        System.out.println("right rotation before for z "+z+" y "+y+" t2 "+T2);

        /*
          z                                 y
         /  \                             /   \
        T1   y                          z      x
            /  \    - - - - - - - ->    / \    / \
           T2   x                     T1  T2 T3  T4
               / \
             T3  T4

        */
        //rotation
        y.right=z;
        z.left = T2;
        System.out.println("right rotation after for z "+z+" y "+y+" t2 "+T2);

        z.height = maxHeight(z) + 1;

        y.height = maxHeight(y) + 1;

        return y;
    }

    private Node leftRotate(Node node) {
        Node z = node;
        Node y = node.right;

        Node T2 = y.left;
        System.out.println("left rotation before for z "+z+" y "+y+" t2 "+T2);

        /*
          z                                y
         /  \                            /   \
        T1   y     Left Rotate(z)       z      x
            /  \   - - - - - - - ->    / \    / \
           T2   x                     T1  T2 T3  T4
               / \
             T3  T4
        */
        //rotation
        y.left=z;
        z.right = T2;
        System.out.println(" left rotation after for z "+z+" y "+y+" t2 "+T2);

        y.height = maxHeight(y) + 1;

        z.height = maxHeight(z) + 1;


        return y;
    }


    int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    int height(Node node){
        return node!=null?node.height:0;
    }

    Node minValueNode(Node node)
    {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    Node deleteNode(Node node ,int key){


        if (node==null)
            return node;

        if (key > node.value){
            node.right = deleteNode(node.right,key);
        }else if (key<node.value){
            node.left = deleteNode(node.left,key);
        }else {

            // node to delete found, now analyse replacement
            if (node.left==null){
                node=node.right;
            }else if (node.right==null){
                node=node.left;
            }else {
                //search 1st min , but more than node to delete
                Node temp= minValueNode(node.right);

                node.value = temp.value;

                node.right = deleteNode(node.right,temp.value);
            }

        }
        if (node==null)
            return node;

        node.height = 1 + maxHeight(node);

        int balance = getBalance(node.left,node.right);

            // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }



    private int getBalance(Node left, Node right) {

        return height(left)-height(right);
    }


}
