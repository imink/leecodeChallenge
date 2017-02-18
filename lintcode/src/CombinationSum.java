/**
 * https://leetcode.com/problems/combination-sum/
 * Created by imink on 17/02/2017.
 */
import java.util.*;

public class CombinationSum {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        for (int i = 0; i < candidates.length; i ++) {
            int sum = candidates[i];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                res.add(list);
            } else if (sum < target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                recursion(candidates, list, candidates[i], i, target);
            }
        }
        return res;
    }

    public void recursion(int[] candidates, List<Integer> list, int curValue, int start, int target) {
        for (int i = start; i < candidates.length; i ++) {
            int sum = curValue + candidates[i];
            if (sum > target) {
                return;
            }
            else if (sum == target) {

                list.add(candidates[i]);
                res.add(list);
                return;
            } else {
                // TODO: 17/02/2017 why new list first and add to new list?
                List<Integer> newList = new ArrayList<>(list);
                newList.add(candidates[i]);
                recursion(candidates, newList, sum, i, target);
            }
        }
    }
    public static void main (String[] args) {
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> list = cs.combinationSum(new int[]{2,3,6,7}, 7);
        for (List subList: list) {
            for (Object item: subList) {
                System.out.print((int)item + " ");
            }
            System.out.println();
        }
    }
}
