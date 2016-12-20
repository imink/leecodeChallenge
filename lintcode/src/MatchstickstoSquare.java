/**
 *
 Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

 Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you can save this little girl or not.

 Example 1:
 Input: [1,1,2,2,2]
 Output: true

 Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 Example 2:
 Input: [3,3,3,3,4]
 Output: false

 Explanation: You cannot find a way to form a square with all the matchsticks.
 Note:
 The length sum of the given matchsticks is in the range of 0 to 10^9.
 The length of the given matchstick array will not exceed 15.
 * Created by imink on 19/12/2016.
 */
import java.util.*;
public class MatchstickstoSquare {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0, avg = 0;
        for (Integer i: nums) {
            sum = sum + i;
        }
        if (sum % 4 != 0) return false;
        else avg = sum / 4;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[r] == avg) {
                r --;
            } else if (nums[r] < avg){
                nums[r] = nums[r] + nums[l];
                l ++;
            } else {
                return false;
            }
        }
        if (nums[r] == avg) return true;
        else return false;
    }
    public boolean dfs(int[] nums, int l, int r, int t) {
        int sum = 0;

        for (int i = l; i < r; i ++) {
            sum = nums[i] + nums[r];
            if (sum == t) return true;
        }
        sum = nums[r] + nums[l];
        for (int i = l; i < r; i ++) {
            for (int j = i + 1; j < r; j ++) {
                int temp = sum + nums[j];
                if (temp == t) return true;
                else if (temp > t) break;
            }
            sum = sum + nums[i + 1];
        }
        return false;
    }

    public boolean makesquare1(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0, avg = 0;
        for (Integer i: nums) {
            sum = sum + i;
        }
        if (sum % 4 != 0) return false;
        else avg = sum / 4;
        Arrays.sort(nums);
        int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
        return helpler(nums, nums.length - 1, sum1, sum2, sum3, sum4, avg);
    }

    public boolean helpler(int[] nums, int len, int sum1, int sum2, int sum3, int sum4, int avg) {
        if (sum1 > avg || sum2 > avg || sum3 > avg || sum4 > avg) {
            return false;
        }
        if (len == -1) {
            if (sum1 == avg && sum2 == avg && sum3 == avg && sum4 == avg) {
                return true;
            } else {
                return false;
            }
        }
        return helpler(nums, len - 1, sum1 + nums[len], sum2, sum3, sum4, avg)
                || helpler(nums, len - 1, sum1, sum2 + nums[len], sum3, sum4, avg)
                || helpler(nums, len - 1, sum1, sum2, sum3 + nums[len], sum4, avg)
                || helpler(nums, len - 1, sum1, sum2, sum3, sum4 + nums[len], avg);

    }
}

