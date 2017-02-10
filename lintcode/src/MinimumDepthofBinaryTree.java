/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Created by imink on 11/02/2017.
 */
import base.TreeNode;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return findMax(root, 1);
    }

    public int findMax(TreeNode node, int count) {
        if (node.left != null && node.right != null) {
            count = Math.min(findMax(node.left, count + 1), findMax(node.right, count + 1));
        }

        if (node.left != null && node.right == null) {
            count = findMax(node.left, count + 1);
        }

        if (node.right != null && node.left == null) {
            count = findMax(node.right, count + 1);
        }

//        if (node.right == null && node.left == null) {
//            return count;
//        }

        return count;
    }
}
