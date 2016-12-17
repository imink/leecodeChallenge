/**
 * https://leetcode.com/problems/rotate-list/
 * Created by imink on 17/12/2016.
 */
public class RotateList {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // TODO: 17/12/2016 Silly solution by copy each node
    public ListNode rotateRight(ListNode head, int k) {
        ListNode node = head;
        int len = 0;
        if (head == null) return null;
        if (k <= 0) return head;
        while (node != null) {
            len ++;
            node = node.next;
        }
        if (len <= k) return head;
        int counter = 0;
        node = head;
        ListNode halfOneHead = node;
        ListNode halfTwoHead = null;

        while (true) {
            //System.out.println(counter+" "+len);
            if (counter < len - k) {
                node = node.next;
                head = head.next;
            }
            else if (counter == len - k) {
                node = null;
                halfTwoHead = head;
            }
            else if (counter < len && counter > len - k){
                head = head.next;
            }
            else if (counter == len) {
                head.next = halfOneHead;
                break;
            }
            counter ++;
        }
        return halfTwoHead;
    }

    // TODO: 17/12/2016 smart solution without accessing the all the nodes

}
