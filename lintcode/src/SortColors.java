/**
 * https://leetcode.com/problems/sort-colors/
 * Created by imink on 28/12/2016.
 */
public class SortColors {
    public int[] nums;
    public void sortColors(int[] nums) {
        this.nums = nums;
        if (nums == null || nums.length <= 1) return; // TODO: 28/12/2016 edge case handle
        int s = 0, e = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 2 && i < e) swap(i, e--);
            while (nums[i] == 0 && i > s) swap(s++, i);
        }
    }

    public void swap(int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
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
