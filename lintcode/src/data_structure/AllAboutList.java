package data_structure;
import base.DoubleListNode;
import base.ListNode;
/**
 * Created by imink on 14/03/2017.
 */
public class AllAboutList {

    public ListNode reverseSingleLinkedList(ListNode head) {
        if (head == null) return null;

        ListNode node = head.next; // skip to 2nd node
        ListNode prev = head;
        prev.next = null; // handle the 1st node
        while (node != null) {
            ListNode temp = node.next; // record the original list
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    public ListNode reverseListRec(ListNode head) {
        // if there is no node, or only one node, just return;
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reHead = reverseListRec(head.next); // 先求解子问题。
        head.next.next = head;  // 将head 与被解决的子串的尾部相连。
        head.next = null;       // head的下一个必须指向 null，因为head 是新的尾部.

        return reHead;
    }

    // 递归打印倒数第k个节点
    public static int reGetKthNodeRec2(ListNode head, int k) {
        if (head == null) {
            return 0;
        }

        int len = reGetKthNodeRec2(head.next, k);
        if (len == k - 1) {
            System.out.println(head.val);
        }
        return len + 1;
    }


    public DoubleListNode reverseDoubleLinkedList(DoubleListNode head) {
        DoubleListNode node = head;
        while (node != null) {
            DoubleListNode temp = node.next;
            node.next = node.prev;
            node.prev = temp;
            node = node.next;
        }

        return null;
    }

    // 获取中间节点
    public static ListNode getMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 递归合并2个list
    public static ListNode mergeSortedListRec(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }
        ListNode headMerge = null;
        if (head1.val < head2.val) {
            headMerge = head1;
            head1.next = mergeSortedListRec(head1.next, head2);
        } else {
            headMerge = head2;
            head2.next = mergeSortedListRec(head1, head2.next);
        }
        return headMerge;
    }


}
