/**
 * Created by imink on 19/10/2016.
 */


import sun.jvm.hotspot.utilities.HashtableEntry;

import java.awt.*;
import java.util.*;
public class LintCode465 {
    // cannot easily to remove duplicate, notice that 1 + 7 = 8 is different from 2 + 6
    class Node implements Comparable<Node>{
        public int aCol;
        public int bCol;
        public int value;
        public int identifier;
        public Node (int _aC, int _bC, int _v, int _i) {
            this.aCol = _aC;
            this.bCol = _bC;
            this.value = _v;
            this.identifier = _i;
        }

        @Override
        public int compareTo(Node another) {
            if (this.value == another.value) {
                return 0;
            }
            return this.value < another.value ? -1 : 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            } else if (!(obj instanceof Node)) {
                return false;
            }
            Node another = (Node) obj;
            return this.aCol == another.aCol && this.bCol == another.bCol;
        }

        @Override
        public int hashCode() {
            return aCol * 101 + bCol;
        }
    }

    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        int selected = 0;
        int aCol = 0, bCol = 0;
        HashSet<Node> visitedArray = new HashSet<Node>();
        PriorityQueue<Node> queue = new PriorityQueue<Node>();

        queue.offer(new Node(0, 0, A[0] + B[0], 0));
        visitedArray.add(new Node(A[0], B[0], A[0] + B[0], 0));
        for (int i = 0; i < k; i ++) {
            Node temp = queue.poll();
            selected = temp.value;
//            visitedArray.add(new Node(temp.aCol, temp.bCol, temp.value, 0));

            System.out.println(temp.value);
            if (aCol < A.length && bCol < B.length) {

                calPair(k, queue, A, B, 0, aCol, bCol, visitedArray);
                calPair(k, queue, A, B, 1, aCol, bCol, visitedArray);
                aCol ++;
                bCol ++;
            }

        }

        return selected;
    }

    public void calPair(int k, PriorityQueue<Node> queue, int[] A, int[] B, int identifier, int aCol, int bCol, HashSet<Node> visitedArray) {
        int boundary = 0;
        if (identifier == 0) {
            if (bCol + k > B.length) boundary = B.length;
            else boundary = bCol + k;
            for (int i = bCol; i < boundary; i ++) {
                int value = A[aCol] + B[i];
//                Node temp1= new Node(aCol, i, value, identifier);

                if (!visitedArray.contains(new Node(A[aCol], B[i], value, identifier))) {
                    System.out.println("A" + value);
                    queue.offer(new Node(aCol, i, value, identifier));
                    visitedArray.add(new Node(A[aCol], B[i], value, identifier));
                    visitedArray.add(new Node(A[i], B[aCol], value, identifier));

//                    visitedArray[aCol][i] = true;
                }
            }
        } else {
            if (aCol + k > A.length) boundary = A.length;
            else boundary = aCol + k;

            for (int i = aCol; i < boundary; i ++) {
                int value = B[bCol] + A[i];
                Node temp1 = new Node(A[i], B[bCol], value, identifier);
//                System.out.println(temp1.to);
                if (!visitedArray.contains(temp1)) {
                    System.out.println("B" + value);
                    queue.offer(new Node(i, bCol, value, identifier));
                    visitedArray.add(temp1);
                    visitedArray.add(new Node(A[bCol], B[i], value, identifier));

                }
            }
        }
    }

    public static void main(String args[]) {
        int[] A = {1,7,11};
        int[] B= {2,4,6};
        int k = 8;
        LintCode465 obj = new LintCode465();
        System.out.println(obj.kthSmallestSum(A, B, k));
    }
}
