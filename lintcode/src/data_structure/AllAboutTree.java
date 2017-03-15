package data_structure;
import apple.laf.JRSUIUtils;
import base.TreeNode;

import java.util.*;

/**
 * Created by imink on 14/03/2017.
 */
public class AllAboutTree {
    public LinkedList<Integer> res = new LinkedList<>();
    // get nodes number iteratively by queue
    public static int getNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            count++;
        }
        return count;
    }

    // get nodes number in a tree recursive
    public static int getNumRec(TreeNode node) {
        if (node == null) return 0;
        return getNumRec(node.left) + getNumRec(node.right) + 1;
    }

    public static int getDepthRec(TreeNode root) {
        if (root == null) return 0; // start from 0;
        return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
    }

    // TODO: 15/03/2017 getDepthItr
    public static int getDepthItr(TreeNode root) {
        if (root == null) return 0;
        TreeNode dummy = new TreeNode(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(dummy);

        int depth = -1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == dummy) {
                depth++;
                // the nodes within two dummy are in the same layer
                if (!queue.isEmpty()) {
                    queue.offer(dummy);
                }
            }
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return depth;
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
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                res.add(node.val);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                TreeNode curNode = stack.pop();
                node = curNode.right;
            }

        }
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
            // push to stack top -> down, to the bottom
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // read node down -> top
            if (!stack.isEmpty()) {
                // the bottom left one
                TreeNode curNode = stack.pop();
                res.add(curNode.val);
                node = curNode.right;
            }
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

    public void postOrderItr(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if(temp.left==null && temp.right==null) {
                TreeNode pop = stack.pop();
                res.add(pop.val);
            }
            else {
                if(temp.right!=null) {
                    stack.push(temp.right);
                    temp.right = null;
                }

                if(temp.left!=null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
    }

    // 获取第k层所有节点的数量
    public static int getNodesNumKthLevelRec(TreeNode root, int k) {
        if (root == null || k <= 0) return 0;
        if (k == 1) return 1;
        return getNodesNumKthLevelRec(root.left, k - 1) + getNodesNumKthLevelRec(root.right, k - 1);
    }

    // 获取第k层所有节点的数量, 用非递归, queue来做
    public static int getNodesNumKthLevelItr(TreeNode root, int k) {
        return 0;
    }

}
