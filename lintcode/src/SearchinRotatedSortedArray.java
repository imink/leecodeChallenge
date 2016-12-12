/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Created by imink on 12/12/2016.
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) return mid;
            if (nums[start] < nums[mid]) {
                // normal
                if (target < nums[mid] && target >= nums[start]) end = mid;
                else start = mid;
            }
            if (nums[mid] < nums[end]) {
                if (target >= nums[mid] && target <= nums[end]) start = mid;
                else end = mid;
            }

        }
        System.out.println(end);
        if (target == nums[start]) return start;
        if (target == nums[end]) return end;
        return -1;
    }
}
