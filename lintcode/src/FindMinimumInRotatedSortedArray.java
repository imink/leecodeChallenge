/**
 * Created by imink on 14/02/2017.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return getMin(nums, 0, nums.length - 1);
    }

    public int getMin(int[] nums, int left, int right) {
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        if (left >= right) {
            return nums[right];
        }

        int mid = left + right;
        return Math.min(getMin(nums, left, mid - 1), getMin(nums, mid, right));
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        System.out.print(obj.findMin(new int[]{3,1,3}));
    }
}
