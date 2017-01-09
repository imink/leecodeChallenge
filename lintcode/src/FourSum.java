/**
 * https://leetcode.com/problems/4sum/
 * Created by imink on 08/01/2017.
 *
 * Input:
 [-1,2,2,-5,0,-1,4]
 3
 Output:
 [[-5,2,2,4]]
 Expected:
 [[-5,2,2,4],[-1,0,2,2]]
 */
import java.util.*;
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        // TODO: 08/01/2017 understanding the underlying principle
        Arrays.sort(nums);

        for (int i = 3; i <= nums.length - 1; i ++) {
            if (i <= nums.length - 2 && nums[i] == nums[i + 1]) continue;
            for (int j = 2; j < i; j ++) {
                if (j <= nums.length - 3 && nums[j] == nums[j + 1]) continue;
                int l = 0;
                int r = j - 1;
                while (l < r) {
                    int sum = nums[l] + nums[r] + nums[j] + nums[i];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[l], nums[r], nums[j], nums[i]));
                        l ++;
                        r --;
                        while (l < r && nums[l] == nums[l - 1]) l ++;
                        while (l < r && nums[r] == nums[r + 1]) r --;
                    } else if (sum > target) {
                        r --;
                    } else {
                        l ++;
                    }
                }
            }
        }
        return res;
    }
}
