/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * Created by imink on 11/02/2017.
 */
import base.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return checkDFS(root) != -1;
    }


    // 1. bottom up approach O(N)
    public int checkDFS(TreeNode node) {
        if (node == null)  return 0;

        int left = checkDFS(node.left);
        if (left == -1) return -1;
        int right = checkDFS(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }



    // 2. topDown approach O(N^2)
    public int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    public boolean isBalancedII(TreeNode root) {
        if (root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) > 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // 3. post order iterative // TODO: 28/02/2017 iterative way
    public boolean isBalancedItr(TreeNode root) {
        if (root == null) return true;
        TreeNode node = root;
        while (true) {
            if (node.left != null) {

            } else if (node.right != null) {

            } else {

            }
        }
    }

}
