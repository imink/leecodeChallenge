import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by imink on 23/10/2016.
 */
public class LintCode0003 {
    private PriorityQueue<Integer> maxHeap, minHeap;
    private int index = 0;

    public int[] medianII(int[] nums) {
        Comparator<Integer> descenCmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        int inputLength = nums.length;
        maxHeap = new PriorityQueue<Integer>(inputLength, descenCmp);
        minHeap = new PriorityQueue<Integer>(inputLength);

        int[] results = new int[inputLength];
        for (int i = 0; i < inputLength; i ++) {
            addNumber(nums[i]);
            results[i] = getMedian();
        }

        return results;
    }

    void addNumber(int number) {
        maxHeap.add(number);
        // if is even, i.e. input length is odd
        if (index % 2 == 0) {
            if (minHeap.isEmpty()) {
                index ++;
                // TODO: 23/10/2016 return meaning?
                return;
            } else if (maxHeap.peek() > minHeap.peek()) {
                // TODO: 23/10/2016 why Integer not int
                Integer maxHeapRoot = maxHeap.poll();
                Integer minHeapRoot = minHeap.poll();
                minHeap.add(maxHeapRoot);
                maxHeap.add(minHeapRoot);
            }
            // else that: new number is smaller than minHeap, so add it to the maxHeap
        }
        // if is odd, input length is even
        else {
            minHeap.add(maxHeap.poll());
        }
        index ++;
    }


    int getMedian() {
        return maxHeap.peek();
    }

}
