/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Created by imink on 13/02/2017.
 */
import base.TreeNode;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sorting(nums, 0, nums.length - 1);
    }

    public TreeNode sorting(int[] nums, int start, int end) {
        if (start - end == 0) {
            return new TreeNode(nums[start]);
        } else if (start - end > 0) {
            return null;
        } else {
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sorting(nums, start, mid - 1);
            node.right = sorting(nums, mid + 1, end);
            return node;
        }
    }
}
