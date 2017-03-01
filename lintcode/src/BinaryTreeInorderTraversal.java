/**
 * Created by imink on 19/02/2017.
 */
import apple.laf.JRSUIUtils;
import base.TreeNode;

import java.util.*;

public class BinaryTreeInorderTraversal {
    // recursive way
    static List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        res = new ArrayList<>();
        postOrder(root);
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

    public void preOrderItr(TreeNode node) {

    }

    // post order 后序遍历 from root to top, from left to right
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            res.add(node.val);
        }
    }

    public void postOrderItr(TreeNode node) {

    }

    public TreeNode generateTree(int[] treeArray) {
        int i = 0;
        Queue<TreeNode> curHightQueue = new LinkedList<>();
        TreeNode root = new TreeNode(treeArray[0]);
        curHightQueue.add(root);
        TreeNode curNode;

        int size = treeArray.length;
        while (!curHightQueue.isEmpty()) {
            curNode = curHightQueue.poll();
            if (2 * i + 1 > size - 1) break;
            curNode.left = new TreeNode(treeArray[2 * i + 1]);
            curHightQueue.add(curNode.left);
            if (2 * i + 2 > size - 1) break;
            curNode.right = new TreeNode(treeArray[2 * i + 2]);
            curHightQueue.add(curNode.right);
            i ++;
        }
        return root;
    }

    // construct a tree
    public static void main(String[] args) {
        // generate trees
        int[] treeArray = new int[]{1,2,3,4,5,6};

        BinaryTreeInorderTraversal obj = new BinaryTreeInorderTraversal();
        TreeNode root = obj.generateTree(treeArray);
        obj.inorderTraversal(root);
        for (int j = 0; j < res.size(); j ++) {
            System.out.println(res.get(j));
        }

    }

}
