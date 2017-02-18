/**
 * Created by imink on 19/02/2017.
 */
import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    // recursive way
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        res = new ArrayList<>();
        recursion(root);
        return res;
    }
    public void recursion(TreeNode node) {
        if (node != null) {
            recursion(node.left);
            res.add(node.val);
            recursion(node.right);
        }
    }
}
