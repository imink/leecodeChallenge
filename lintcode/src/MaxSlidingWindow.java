/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * http://www.lintcode.com/en/problem/sliding-window-maximum/
 * Created by imink on 25/10/2016.
 */
import java.util.*;
public class MaxSlidingWindow {
    void inQueue(Deque<Integer> deque, int num) {
        // peak last is the last largest element that was inserted into the queue.
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        // add to the tail
        deque.offer(num);
    }

    void outQueue(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }

    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();

        if (nums.length == 0) {
            return ans;
        }

        for (int i = 0; i < k - 1; i ++) {
            inQueue(deque, nums[i]);
        }

        for (int i = k - 1; i < nums.length; i ++) {
            // add the tail of window
            inQueue(deque, nums[i]);
            // first element is the largest
            ans.add(deque.peekFirst());
            // remove the head of window
            outQueue(deque, nums[i - k + 1]);
        }

        return ans;

    }
}
