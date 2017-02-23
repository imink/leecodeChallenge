/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * Created by imink on 20/02/2017.
 */
import base.ListNode;
public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode node = head;
        ListNode lastHead = new ListNode(0);
        int count = 1;
        ListNode firstBreakNode = null;
        ListNode curHead = null;
        ListNode subTail = null;
        ListNode curNode = null;

        while (node != null) {
            if (count == m - 1) {
                firstBreakNode = node;
                curHead = firstBreakNode.next;
            }
            if (count >= m && count <= n) {
                curHead.next = lastHead;
                if (count == m) {
                    subTail = lastHead;
                    curHead.next = subTail;
                    curNode = node;
                }
                curHead = curNode;
//                System.out.println(count);
                lastHead = curHead;
                curNode = curNode.next;
            }
//            if (count == n) subTail.next = node;
            System.out.println(node.val);
            count ++;

            node = node.next;
        }

//        firstBreakNode.next = curHead;
        return node;
    }

    public static void printList (ListNode input) {
        ListNode res = input;
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
        System.out.print("\n");

    }

    public static void main(String[] args) {
//        int[] array = {1,3,7,8,2,5,2,4,6};
        int[] array = {1,2,3,4,5};
        ListNode input = new ListNode(0);
        ListNode head = input;

        for (int i = 0; i < array.length; i ++) {
            input.next = new ListNode(array[i]);
            input = input.next;
        }
        ListNode res = reverseBetween(head.next, 2, 4);
        printList(res);
    }
}
