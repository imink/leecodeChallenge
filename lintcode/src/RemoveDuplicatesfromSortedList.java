/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Created by imink on 19/12/2016.
 */
public class RemoveDuplicatesfromSortedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode prevNode = head;
        ListNode resNode = head;
        while (head.next != null) {
            head = head.next;
            if (head.val == prevNode.val) {
                prevNode.next = head.next;
            } else  {
                prevNode = head;
            }
        }
        return resNode;
    }
}