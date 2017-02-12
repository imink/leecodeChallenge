/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * Created by imink on 11/02/2017.
 */
import base.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return check(root) != -1;
    }

    public int check(TreeNode node) {
        if (node == null)  return 0;

        int left = check(node.left);
        if (left == -1) return -1;
        int right = check(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

}
