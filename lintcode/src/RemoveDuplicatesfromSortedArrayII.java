/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Created by imink on 03/01/2017.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int cur = 0, next = 0, flag = 1;

        while (next < nums.length - 1) {
            if (nums[cur] < nums[next + 1]) {
                nums[cur + 1] = nums[next + 1];
                cur ++;
                next ++;
                flag = 1;
            } else if (nums[cur] == nums[next + 1] && flag < 2) {
                nums[cur + 1] = nums[next + 1];
                flag ++;
                next ++;
                cur ++;
            } else {
                next ++;
            }
        }
        return cur + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3};
        int len = removeDuplicates(nums);
        System.out.println("len: " + len + " array: ");
        for (Integer i : nums) {
            System.out.print(i);
        }
    }
}
