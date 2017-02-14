/**
 * Created by imink on 14/02/2017.
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int r = nums[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (nums[i] < 0) {
                int temp = imin;
                imin = imax;
                imax = temp;
            }
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }

    public static void main(String[] args){
        System.out.print(maxProduct(new int[]{-2}));
    }
}
