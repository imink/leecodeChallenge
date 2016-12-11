/**
 * https://leetcode.com/problems/maximum-subarray/
 * Created by imink on 07/12/2016.
 *
 * [SOL]
 * dp[n] = min(dp[n-1] + a[n], a[n]);
 * and dont forget the init dp
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) return 0;
        int totalMax = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > totalMax) {
                totalMax = dp[i];
            }
        }
        return totalMax;
    }
}
