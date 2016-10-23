/**
 * Created by imink on 19/10/2016.
 */

import java.util.*;

public class LintCode543 {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    class Node {
        public int value, row, length;
        public Node(int _v, int _r, int _l) {
            this.value = _v;
            this.row = _r;
            this.length = _l;
        }
    }

    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        final int selected = 0;
        Queue<Node> queue = new PriorityQueue<Node>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.value > o2.value)
                    return -1;
                else if (o1.value < o2.value)
                    return 1;
                else
                    return 0;
            }
        });



        for (int i = 0; i < arrays.length; i ++) {
            Arrays.sort(arrays[i]);
            if (arrays[i].length > 0) {
                queue.offer(new Node(arrays[i][arrays[i].length - 1], i, arrays[i].length));
            }
        }

        int value = 0;
        for (int i = 0; i < k; i ++) {
            Node temp = queue.poll();
            value = temp.value;
            int row = temp.row;
            int length = temp.length;

            if (length > 1) {
                length --;
                queue.offer(new Node(arrays[row][length - 1], row, length));
            }

        }
        return value;
    }

    public static void main(String args[]) {
        int[][] arrays = {{9,3,2,4,7}, {1,2,3,4,8}};
        int target = 3;
        LintCode543 obj = new LintCode543();
        System.out.println(obj.KthInArrays(arrays, target));
    }


}
