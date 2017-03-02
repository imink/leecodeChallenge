import java.util.Stack;
/**
 * Created by imink on 03/01/2017.
 */
public class LargestRectangleinHistogram {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int res = 0;
        int len = heights.length;
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < len + 1; i ++) {
            int cur = i == len ? -1 : heights[i]; // handle the height[len]
            while (!S.empty() && cur <= heights[S.peek()]) {
                // remove the top one
                int top = S.pop();
                // calculate the previous rec
                if (S.empty()) {
                    res = Math.max(res, heights[top] * i);
                } else {
                    // peek is now the latest top
                    res = Math.max(res, heights[top] * (i - S.peek() - 1));
                }
            }
            // push the current one
            S.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{5,1,4}));
    }
}
