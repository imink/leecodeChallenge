/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * Created by imink on 10/02/2017.
 */
public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next != null) {
            ListNode temp = head;
            head = head.next;
            head.next = temp;
        }
        ListNode node = head;
        node = node.next;
        return head;
    }

    public void swap(ListNode first, ListNode next) {

    }
}
