/**
 * https://leetcode.com/problems/symmetric-tree/
 * Created by imink on 06/12/2016.
 */
import java.util.*;

public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // only check those exceptions.
    public boolean check (TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true; // end of the tree
        if (leftNode == null || rightNode == null) return false; // null, not null pair
        if (leftNode.val != rightNode.val) return false; // value not equal
        return check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left);
    }

    public boolean isSymmetric (TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }


    // BFS way
    public boolean iterative1 (TreeNode root) {
        Deque<TreeNode> nextQueue  = new LinkedList<>();
        Deque<TreeNode> curQueue  = new LinkedList<>();
        if (root == null) return true;

        curQueue.add(root);
        while (!curQueue.isEmpty()) {
            while (!curQueue.isEmpty()) {

                TreeNode curNode = curQueue.poll();
                nextQueue.add(curNode.left);
                nextQueue.add(curNode.right);

            }
            if (!nextQueue.isEmpty()) {
                curQueue = nextQueue;
                nextQueue = new LinkedList<>();
            }

            TreeNode first = curQueue.peekFirst();
            TreeNode last = curQueue.peekLast();
            while (true) {
                if ((first == null && last != null) || (last == null && first != null)) return false;
                if (first != null && last != null) {
                    if (first.val != last.val) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean iterative2 (TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> leftQ = new LinkedList<>();
        Queue<TreeNode> rightQ = new LinkedList<>();

        leftQ.offer(root.left);
        rightQ.offer(root.right);
        while (!(leftQ.isEmpty() && rightQ.isEmpty())) {
            TreeNode leftNode = leftQ.poll();
            TreeNode rightNode = rightQ.poll();

            if(leftNode == null && rightNode == null) continue;

            if ((leftNode == null && rightNode != null) || (rightNode == null && leftNode != null)) return false;
            if (leftNode != null && rightNode != null) {
                if (leftNode.val != rightNode.val) return false;
            }


            if (!(leftNode.left == null && rightNode.right == null)) {
                leftQ.offer(leftNode.left);
                rightQ.offer(rightNode.right);
            }
            if (!(leftNode.right == null && rightNode.left == null)) {
                leftQ.offer(leftNode.right);
                rightQ.offer(rightNode.left);
            }
        }

        return true;
    }



}
