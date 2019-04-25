package codeChef.April19Div2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sachin on 11/4/19.
 *
 *
 *
 *
 *  There is a field with plants — a grid with N rows (numbered 1 through N) and M columns (numbered 1 through M);
 *  out of its NM cells, K cells contain plants, while the rest contain weeds. Two cells are adjacent if they have a common side.

 You want to build fences in the field in such a way that the following conditions hold for each cell
 that contains a plant:

 it is possible to move from this cell to each adjacent cell containing a plant without crossing any fences
 it is impossible to move from this cell to any cell containing weeds or to leave the grid without crossing any fences
 The fences can only be built between cells or on the boundary of the grid, i.e. on the sides of cells.
 The total length of the built fences is the number of pairs of side-adjacent cells such that there is a fence built on their common side
 plus the number of sides of cells on the boundary of the grid which have fences built on them. Find the minimum required total length of fences that need to be built.


 Input
 The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
 The first line of each test case contains three space-separated integers N, M and K.
 K lines follow. Each of these lines contains two space-separated integers r and c denoting that the cell in row r and column c contains a plant.
 Output
 For each test case, print a single line containing one integer — the minimum required length of fences.

 Constraints
 1≤T≤10
 1≤N,M≤109
 1≤K≤105
 1≤r≤N
 1≤c≤M
 the cells containing plants are pairwise distinct
 Subtasks
 Subtask #1 (30 points): 1≤N,M≤1,000
 Subtask #2 (70 points): original constraints

 Example Input
 2
 4 4 9
 1 4
 2 1
 2 2
 2 3
 3 1
 3 3
 4 1
 4 2
 4 3
 4 4 1
 1 1
 Example Output
 20
 4
 Explanation
 Example case 1: The field looks like this ('x' denotes a cell containing a plant, '.' denotes a cell containing weeds):

 ...x
 xxx.
 x.x.
 xxx.
 An optimal solution is to build fences around the topmost plant (with length 4),
 around the remaining eight plants (with length 12) and around the hole between them (with length 4). The total length is 4+12+4=20.
 *
 * ### Reduce data collection to plants only and then run BFS
 *
 */
public class Fencing {

    static class Node{
        Point location;
        boolean isPlant;

        public Node(Point location, int isPlant) {
            this.location = location;
            this.isPlant = (isPlant==1);
        }

        @Override
        public boolean equals(Object obj) {
            Node node= (Node)obj;
            return (location.x==node.location.x )&& (location.y==node.location.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(new Integer(location.x) ,new Integer(location.y),isPlant);
        }

        @Override
        public String toString() {
            return location +" "+ (isPlant?"plant":"weed");
        }
    }

    static class Point{
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[ "+x+" "+y+" ]";
        }
    }


   static List<Node>[][] filedPaths =null;
    static   int field[][] =null;
    static int rows,cols =0;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new FileReader(new File("src/input.in")));

        int test= Integer.parseInt(reader.readLine());
        while (test >0){
            Long st = System.currentTimeMillis();
            String[] inp = reader.readLine().split(" ");

           rows= Integer.parseInt(inp[0]);
           cols = Integer.parseInt(inp[1]);
            int plants = Integer.parseInt(inp[2]);
            field = new int[rows][cols];

            filedPaths =new List[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    filedPaths[i][j]=new LinkedList();
                }
            }

            for (int i = 0; i < plants; i++) {
                 inp = reader.readLine().split(" ");
                field[Integer.parseInt(inp[0])-1][Integer.parseInt(inp[1])-1]=1;
            }

           /* for (int i = 0; i < rows; i++) {

                System.out.println(Arrays.toString(field[i]));
            }*/

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                   // filedPaths[i][j].add(new Node(new Point(i,j),field[i][j]));
                    if (j-1>=0){//left
                        filedPaths[i][j].add(new Node(new Point(i,j-1),field[i][j-1]));
                    }

                    if (j+1<cols){// right
                        filedPaths[i][j].add(new Node(new Point(i,j+1),field[i][j+1]));
                    }

                    if (i-1>=0){// up
                        filedPaths[i][j].add(new Node(new Point(i-1,j),field[i-1][j]) );
                    }

                    if (i+1<rows){// down
                        filedPaths[i][j].add(new Node(new Point(i+1,j),field[i+1][j]));
                    }

                }
            }

          /*  for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.println("f["+i+"]["+j+"] "+filedPaths[i][j]);
                }
            }*/

            boolean[][] isVisited = new boolean[rows][cols];
           int sum =0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    if (!isVisited[i][j]){
                      sum +=  BFSutil(isVisited,new Node(new Point(i,j),field[i][j]) );
                    }
                }
            }
            System.out.println(sum);


           // System.out.println("\n\n\n");
            test--;
            Long et = System.currentTimeMillis();
            System.out.println((st-et)/1000);
        }


    }

    static int BFSutil(  boolean[][] isVisited, Node node){
        isVisited[node.location.x][node.location.y]=true;
        if (!node.isPlant){
            isVisited[node.location.x][node.location.y]=true;
            return 0;
        }

        Set<Node> nodes = new HashSet<>();
        LinkedList<Node> queue=new LinkedList<>();

        queue.add(node);
        nodes.add(node);
        int sum =4;
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            Iterator<Node> i = filedPaths[temp.location.x][temp.location.y].iterator();
            while (i.hasNext())
            {
                Node n = i.next();

                if (n.isPlant && !isVisited[n.location.x][n.location.y])
                {
                    sum =sum+ (4-(2*findTouchPoints(nodes,n)));

                    nodes.add(n);
                    isVisited[n.location.x][n.location.y] = true;
                    queue.add(n);
                }else {
                    isVisited[n.location.x][n.location.y] = true;
                }
            }

        }
        return sum;
    }

    static int findTouchPoints(Set<Node> visited,Node node){

        int counter=0;

        if (node.location.x-1>=0){
            Node left = new Node(new Point(node.location.x-1,node.location.y),field[node.location.x-1][node.location.y]) ;
            if (visited.contains(left)){
                counter++;
            }
        }

        if (node.location.x+1<cols){
            Node left = new Node(new Point(node.location.x+1,node.location.y),field[node.location.x-1][node.location.y]) ;
            if (visited.contains(left)){
                counter++;
            }
        }

        if (node.location.y-1>=0){
            Node left = new Node(new Point(node.location.x,node.location.y-1),field[node.location.x][node.location.y-1]) ;
            if (visited.contains(left)){
                counter++;
            }
        }

        if (node.location.y+1<rows){
            Node left = new Node(new Point(node.location.x,node.location.y+1),field[node.location.x][node.location.y+1]) ;
            if (visited.contains(left)){
                counter++;
            }
        }

        return counter;
    }

}
