/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Created by imink on 13/12/2016.
 */
import java.util.*;

public class MergeKSortedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            if (o1 == null) return 1;
            else if (o2 == null) return -1;
            // ascending order
            return o1.val - o2.val;
        }
    };

    public ListNode mergeKLists(ListNode[] lists) {
        // TODO: 13/12/2016 notice that return null not empty object
        if (lists.length == 0 || lists == null) return null;
        ListNode res = new ListNode(0);

        Queue<ListNode> mergedQueue = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
        // add all the first node
        for (int i = 0; i < lists.length; i ++) {
            if (lists[i] == null) continue;
            mergedQueue.add(lists[i]);
        }

        // TODO: 13/12/2016 LinkedList: how to keep the head pointer
        ListNode tail = res;
        while(!mergedQueue.isEmpty()) {
            ListNode head = mergedQueue.poll();
            tail.next = head; // always hold the head of ListNode
            tail = head; // move to next pointer
            if (head.next != null) {
                mergedQueue.add(head.next);
            }
        }
        return res.next;
    }
}
