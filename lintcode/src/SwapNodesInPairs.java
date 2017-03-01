/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * Created by imink on 10/02/2017.
 */
import base.ListNode;
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node.next != null && node.next.next != null) {
            ListNode first = node.next;
            ListNode second = node.next.next;
            first.next = second.next;
            second.next = first;
            node.next = second;
            node = node.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairsII(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairsRecursion(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

}


