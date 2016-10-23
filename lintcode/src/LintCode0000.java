/**
 * Created by imink on 21/10/2016.
 */
public class LintCode0000 {
        /**
         * @param heights: an array of integers
         * @return: a integer
         */
        public int trapRainWater(int[] heights) {
            if (heights.length == 0) return 0;
            int[] leftHeights = new int[heights.length];
            int max = 0, area = 0;
            leftHeights[0] = heights[0];
            for (int i = 1; i < heights.length; i ++) {
                if (heights[i] > leftHeights[i - 1]) {
                    max = heights[i];
                } else {
                    max = leftHeights[i - 1];
                }
                leftHeights[i] = max;
//                System.out.println(leftHeights[i]);
            }
            max = 0;
            for (int i = heights.length - 1; i >= 0; i --) {
                if (Math.min(max, leftHeights[i]) >= heights[i]) {
//                    System.out.println(leftHeights[i]);

                    area = area + Math.min(max, leftHeights[i]) - heights[i];
                }
                max = Math.max(heights[i], max);
            }

            return area;
        }

    public static void main(String args[]) {
        int[] arrays = {100, 0, 100};
        int target = 3;
        LintCode0000 obj = new LintCode0000();
        System.out.println(obj.trapRainWater(arrays));
    }

}
