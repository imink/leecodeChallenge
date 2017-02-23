/**
 * https://leetcode.com/problems/decode-ways/
 * Created by imink on 21/02/2017.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() < 1) return 0;
        if (s.length() == 1) {
            int num = Integer.parseInt(s);
            if (num < 1 || num > 26) return 0;
            else return 1;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 1; i < s.length(); i ++) {
            int oneDigit = Integer.parseInt(s.substring(i, i + 1));
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i + 1] += dp[i - 1];
            }
            if (oneDigit >= 1 && oneDigit <= 9){
                dp[i + 1] += dp[i];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays obj = new DecodeWays();
        System.out.println(obj.numDecodings("124"));
    }
}
