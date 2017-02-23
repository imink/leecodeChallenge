/**
 * Created by imink on 19/02/2017.
 */
import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    // recursive way
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        res = new ArrayList<>();
        inOrder(root);
        return res;
    }

    // in order 中序遍历 left to right
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            res.add(node.val);
            inOrder(node.right);
        }
    }

    // in order iterative
    public void inOrderItr(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            // push to stack top -> down
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // read node down -> top
            if (!stack.isEmpty()) {
                TreeNode curNode = stack.pop();
                res.add(curNode.val);
                node = curNode.right;
            }
        }
    }

    // pre order 前序遍历 top->down, left->right
    public void preOrder(TreeNode node) {
        if (node !=null) {
            res.add(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // post order 后序遍历 from root to top, from left to right
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            res.add(node.val);
        }
    }
}
