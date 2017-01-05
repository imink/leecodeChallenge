/**
 * Created by imink on 03/01/2017.
 */
//  Definition for a binary tree node.

public class SameTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        boolean left, right;

        if (p.left != null && q.left != null ) left = isSameTree(p.left, q.left);
        else if (p.left == null && q.left == null) left = true;
        else left = false;

        if (p.right != null && q.right != null) right = isSameTree(p.right, q.right);
        else if (p.right == null && q.right == null) right = true;
        else right = false;

        return left && right;
    }

    public boolean isSameTreeII(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }else if(p==null || q==null){
            return false;
        }

        if(p.val==q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else{
            return false;
        }
    }


}
