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
        TreeNode node = null;
        if (root.val > 0) {
            node = new TreeNode(Integer.MIN_VALUE);
            node.right = root;
            return check(root, node, node.val, Integer.MAX_VALUE);
        }
        if (root.val <= 0) {
            node = new TreeNode(Integer.MAX_VALUE);
            node.left = root;
            return check(root, node, Integer.MIN_VALUE, node.val);
        }
        return true;
    }

    public boolean check(TreeNode node, TreeNode lastN, int left, int right) {
        if (node.val <= left || node.val >= right) return false;

        if (lastN.left != null && lastN.left.val == node.val) {
            if (node.right != null) return check(node.right, node, node.val, right);
            if (node.left != null) return check(node.left, node, left, node.val);
        }
        if (lastN.right != null && lastN.right.val == node.val) {
            if (node.left != null) return check(node.left, node, node.val, left);
            if (node.right != null) return check(node.right, node, right, node.val);
        }

        return true;
    }


}
