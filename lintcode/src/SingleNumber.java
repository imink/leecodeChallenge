/**
 * https://leetcode.com/problems/single-number/
 * Created by imink on 13/02/2017.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i ++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
