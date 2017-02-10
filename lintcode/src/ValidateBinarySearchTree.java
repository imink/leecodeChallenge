/**
 * https://leetcode.com/problems/validate-binary-search-tree/?tab=Description
 * Created by imink on 09/02/2017.
 */
public class ValidateBinarySearchTree {
    //Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // TODO: 10/02/2017 Why we dont need two scenarios?
    public boolean check(TreeNode node, long left, long right) {
        if (node.val <= left || node.val >= right) return false;

        if (node.right != null && node.left == null) return check(node.right, node.val, right);
        if (node.left != null && node.right == null) return check(node.left, left, node.val);
        if (node.right != null && node.right != null) return check(node.right, node.val, right) && check(node.left, left, node.val);

        return true;
    }
}
