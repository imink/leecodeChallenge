/**
 * https://leetcode.com/problems/plus-one/
 * Created by imink on 18/12/2016.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        int l = digits.length - 1;
        while (digits[l] + 1 >= 10) {
            digits[l] = (digits[l] + 1)%10;
            l --;
            if (l < 0) {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                for (int i = 0; i < digits.length; i ++) {
                    newDigits[i + 1] = digits[i];
                }
                return newDigits;
            }
        }
        digits[l] = digits[l] + 1;
        return digits;
    }
}
