/**
 * https://leetcode.com/problems/3sum/
 * Created by imink on 08/01/2017.
 */
import java.util.*;
public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);
        for (int i = 2; i <= nums.length - 1; i ++) {
            // skip the duplicate target
            if (i <= nums.length - 2 && nums[i] == nums[i + 1]) continue;
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] == nums[i] * -1) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    temp.add(nums[i]);
                    res.add(temp);
                    l ++;
                    r --;
                    while (l < r && nums[r] == nums[r + 1]) r --;
                    while (l < r && nums[l] == nums[l - 1]) l ++;
                } else if (nums[l] + nums[r] < nums[i] * -1) {
                    l ++;
                } else if (nums[l] + nums[r] > nums[i] * -1) {
                    r --;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = threeSum(new int[]{-4,-2,-1,0,1,2});
        for (List l : res) {
            for (Object i : l) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
