/**
 * Created by imink on 04/11/2016.
 */
import java.util.*;


public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        // write your code here
        int curMax = 0;
        int left = 0;
        int right = heights.length - 1;

        if (heights.length == 0) return 0;

        while (left < right) {
            if (heights[left] < heights[right]) {
                curMax = Math.max(curMax, (heights[left] * (right - left)));
                left++;
            } else {
                curMax = Math.max(curMax, (heights[right] * (right - left)));
                right--;
            }
        }

        return curMax;
    }
}
