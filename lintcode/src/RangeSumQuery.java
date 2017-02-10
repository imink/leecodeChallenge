/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * Created by imink on 08/02/2017.
 */
public class RangeSumQuery {
    int[] nums = null;

    public RangeSumQuery(int[] nums) {
        for (int i = 1; i < nums.length; i ++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (i == 0) return nums[j];
        else {
            return nums[j] - nums[i - 1];
        }
    }
}
