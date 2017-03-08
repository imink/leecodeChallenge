/**
 * https://leetcode.com/problems/sort-colors/
 * Created by imink on 28/12/2016.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return; // TODO: 28/12/2016 edge case handle
        int s = 0, e = nums.length - 1;

        

    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] array = {2,1,1,0,2};
        sc.sortColors(array);
        for (Integer i: array) {
            System.out.print(i);
        }
    }
}
