/**
 * Created by imink on 03/01/2017.
 */
public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int cur = 0, next = 0;
        while (next < nums.length - 1) {
            if (nums[cur] != nums[next + 1]) {
                nums[cur + 1] = nums[next + 1];
                next ++;
                cur ++;
            } else {
                next ++;
            }
        }

//        return nums[next] == nums[next + 1] ? cur : cur + 1;
        return cur + 1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,0,0,3,3,3,3};
        int len = removeDuplicates(nums);
        System.out.println("len: " + len + " array: ");
        for (Integer i : nums) {
            System.out.print(i);
        }
    }
}
