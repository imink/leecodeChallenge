/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?tab=Description
 * Created by imink on 06/02/2017.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            } else if (sum > target) {
                j --;
            } else if (sum < target) {
                i ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(new String("abcde").substring(0,2));
    }
}
