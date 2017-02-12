/**
 * Created by imink on 05/01/2017.
 */
import base.TreeNode;
public class SumRootToLeafNumbers {

    // TODO: 05/01/2017 setup a global var to store the sum is not a best practice
//    public static int res = 0;
//    public int sumNumbers(TreeNode root) {
//        if (root == null) return 0;
//        if(root.left == null && root.right == null) return root.val;
//        addNode(root, 0);
//        return res;
//    }
//
//    public void addNode(TreeNode node, int last) {
//        last = last * 10 + node.val;
//        if (node.left != null) {
//            addNode(node.left, last);
//        }
//        if (node.right != null) {
//            addNode(node.right, last);
//        }
//        if (node.left == null && node.right == null) {
////            System.out.println(last);
//            res = last + res;
//        }
//    }
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        int res = 0;
        res = addNode(root, 0, 0);
        System.out.println(res);
        return res;
    }

    public int addNode(TreeNode node, int last, int sum) {
        last = last * 10 + node.val;
        int l = 0, r = 0;
        if (node.left != null) {
            l = addNode(node.left, last, sum);
        }
        if (node.right != null) {
            r = addNode(node.right, last, sum);
        }
        if (node.left == null && node.right == null) {
//            System.out.println(last);
            return last;
        }
        return l + r;
    }

}
