/**
 * https://leetcode.com/problems/subsets/
 * Created by imink on 21/12/2016.
 */
import java.util.*;
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        helper(res, list, nums, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int index) {

        print(list);
        res.add(new ArrayList<Integer>(list));

        for (int i = index; i < nums.length; i ++) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void print(ArrayList<Integer> list) {
        for(Integer i: list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        subsets(nums);
    }
}

