/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Created by imink on 07/02/2017.
 */
public class MergeTwoSortedLists {
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode res1 = new ListNode(0);
            ListNode res = res1; // TODO: 07/02/2017 get the header node, and mark it
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    res.next = l1;
                    l1 = l1.next;
                } else {
                    res.next = l2;
                    l2 = l2.next;
                }
                res = res.next;
            }

            if (l1 != null) {
                res.next = l1;
            }
            if (l2 != null) {
                res.next = l2;
            }

            return res.next;
        }
    }
}
