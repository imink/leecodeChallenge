/**
 * Created by imink on 19/10/2016.
 */

import java.util.*;

public class LintCode401 {

    class Node{
        public int row;
        public int col;
        public int value;
        public Node(int row,int col, int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
    /**
     * @param matrix: a matrix of integers
//     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    // does it traverse all the elements?
    private void set(int row,int col,boolean [][] visited, int [][]matrix, PriorityQueue<Node> heap){
        int m = visited.length;
        int n = visited[0].length;
        // edge condition, make sure do not exceeds the boundary, do not access the same ele twice
        if(row<0||row>=m||col<0||col>=n||visited[row][col]) return;
        // then add to the heap
        heap.offer(new Node(row,col,matrix[row][col]));
        System.out.println(row);
        System.out.println(col);

        visited[row][col]=true;
    }
    public int kthSmallest(int[][] matrix, int k) {
        // asceding order
        Comparator<Node> mycompare = new Comparator<Node>(){
            public int compare(Node n1,Node n2){
                return n1.value-n2.value;
            }
        };
        boolean [][] visited = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<Node> heap = new PriorityQueue<Node>(k,mycompare);

        // to poll the first one
        heap.offer(new Node(0,0,matrix[0][0]));
        int selected = 0;
        visited[0][0]=true;
        for(int i=0;i<k;i++){
            // get the top one
            Node node = heap.poll();
            selected = node.value;

            int row = node.row;
            int col = node.col;
            // Qs here????
            set(row+1,col,visited,matrix,heap);//down
            set(row,col+1,visited,matrix,heap);//right
        }
        System.out.println("heap" + heap.size());

        return selected;
    }

    public static void main(String[] args) {
        int[][] array = {{1,5,7},{3,7,8},{4,8,9}};
        int target = 4;
        LintCode401 obj = new LintCode401();
        System.out.println(obj.kthSmallest(array, target));
    }
}