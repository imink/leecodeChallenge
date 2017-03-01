/**
 * https://leetcode.com/problems/symmetric-tree/
 * Created by imink on 06/12/2016.
 */
import base.TreeNode;

import java.util.*;

public class SymmetricTree {
    // only check those exceptions.
    public boolean check (TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true; // end of the tree
        if (leftNode == null || rightNode == null) return false; // null, not null pair
        if (leftNode.val != rightNode.val) return false; // value not equal
        return check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left);
    }

    public boolean isSymmetric (TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }


    // BFS way
    public boolean isSymmetricIterative (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return true;
        if (root.right != null && root.left !=null) {
            stack.add(root.left);
            stack.add(root.right);
        }
        if (root.right == null && root.left == null) return true;
        if (root.right == null || root.left == null) return false;
        while (stack.size() != 0) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (right == null && left == null) continue;
            if (right == null && left != null) return false;
            if (right != null && left == null) return false;
            if (right.val != left.val) return false;

            stack.add(right.right);
            stack.add(left.left);
            stack.add(right.left);
            stack.add(left.right);
            if (stack.size() % 2 != 0) return false;
        }
        return true;
    }

    public boolean iterative2 (TreeNode root) {
        if(root==null)  return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if(root.left!=null){
            if(root.right==null) return false;
            stack.push(root.left);
            stack.push(root.right);
        }
        else if(root.right!=null){
            return false;
        }

        while(!stack.empty()){
            if(stack.size()%2!=0)   return false;
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) return false;

            if(left.left!=null){
                if(right.right==null)   return false;
                stack.push(left.left);
                stack.push(right.right);
            }
            else if(right.right!=null){
                return false;
            }

            if(left.right!=null){
                if(right.left==null)   return false;
                stack.push(left.right);
                stack.push(right.left);
            }
            else if(right.left!=null){
                return false;
            }
        }

        return true;
    }



}
