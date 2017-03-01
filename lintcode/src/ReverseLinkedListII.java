/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * Created by imink on 20/02/2017.
 */
import base.ListNode;

public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode subHead = new ListNode(0);
        ListNode subTail = new ListNode(0);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = head;
        ListNode preNode = dummy;
        int c = 1;

        while (c <= n) {
            ListNode temp = node.next;
            if (c < m) {
                // record the pre node of subList
                preNode = node;
            } else if (c == m) {
                // record subList tail and move cursor backwards
                subTail = node;
                subHead.next = node;
            } else {
                // move cursor backwards
                node.next = subHead.next;
                subHead.next = node;
            }
            node = temp;
            c ++;
        }
        subTail.next = node;
        preNode.next = subHead.next;
        return dummy.next;
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


//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        ListNode dummyhead = new ListNode(0);
//        dummyhead.next = head;
//        ListNode sublisthead = new ListNode(0);
//        ListNode sublisttail = new ListNode(0);
//        int count = 1;
//        ListNode pre_cur = dummyhead, cur = head;
//        while(count <=n){
//            ListNode temp = cur.next;
//            if (count < m)
//                pre_cur = cur;
//            else if (count == m){
//                sublisttail = cur;
//                sublisthead.next = cur;
//            }else if (count > m){
//                cur.next = sublisthead.next;
//                sublisthead.next = cur;
//            }
//            cur = temp;
//            ++count;
//        }
//        pre_cur.next = sublisthead.next;
//        sublisttail.next = cur;
//        return dummyhead.next;
//    }