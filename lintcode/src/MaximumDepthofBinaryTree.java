/**
 * Created by imink on 10/02/2017.
 */
import base.Interval;
import base.TreeNode;

import java.util.*;

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return findMax(root, 1);
    }

    public int findMax(TreeNode node, int count) {
        if (node.left != null && node.right != null) {
            count = Math.max(findMax(node.left, count + 1), findMax(node.right, count + 1));
        }

        if (node.left != null && node.right == null) {
            count = findMax(node.left, count + 1);
        }

        if (node.right != null && node.left == null) {
            count = findMax(node.right, count + 1);
        }
        return count;
    }


    public int maxDepthItrBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 1;
        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size --;
            }
            count ++;
        }
        return count;
    }

    public int maxDepthItrDFS(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> values = new Stack<>();
        stack.push(root);
        values.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = values.pop();
            max = Math.max(temp, max);
            if (node.left != null) {
                stack.push(node.left);
                values.push(temp + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                values.push(temp + 1);
            }
        }
        return max;
    }
}
