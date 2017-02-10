/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 * Created by imink on 06/02/2017.
 */

import base.TreeNode;
public class DeleteNodeInaBST {

    public void cutNode(TreeNode lastN, TreeNode curN, int left) {
        if (left == 2) {
            if (curN.right != null) {
                lastN.left = curN.right;
                TreeNode temp = curN.left;
                curN = curN.right;
                while (curN.left != null) {
                    curN = curN.left;
                }
                curN.left = temp;
            } else {
                lastN.left = curN.left;
            }
        } else if (left == 1) {
            if (curN.left != null) {
                lastN.right = curN.left;
                TreeNode temp = curN.right;
                curN = curN.left;
                while (curN.right != null) {
                    curN = curN.right;
                }
                curN.right = temp;
            } else {
                lastN.right = curN.right;
            }
        } else if (left == 0) {

        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root;
        TreeNode resultN = root;
        TreeNode lastN = node;
        int left = 0;
        while (node != null) {
            if (key == node.val) {
                cutNode(lastN, node, left);
                if (left == 0) {
                    if (root.right != null) {
                        TreeNode temp = root.left;
                        root = root.right;
                        root.left = temp;
                        return root;
                    } else if (root.left != null){
                        TreeNode temp = root.right;
                        root = root.left;
                        root.right = temp;
                        return root;
                    }
                }
                return resultN;
            } else if (key > node.val) {
                lastN = node;
                node = node.right;
                left = 1;
            } else if (key < node.val){
                lastN = node;
                node = node.left;
                left = 2;
            }
        }
        return root;
    }

}
