import java.util.HashMap;

/**
 * http://www.jiuzhang.com/solutions/two-sum/
 * Created by imink on 04/01/2017.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (hashMap.get(nums[i]) != null) {
                res[0] = hashMap.get(nums[i]);
                res[1] = i;
            }
            hashMap.put(target - nums[i], i);
        }
        return res;
    }
}
