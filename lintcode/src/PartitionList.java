/**
 * https://leetcode.com/problems/partition-list/
 * Created by imink on 21/12/2016.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class PartitionList {



    public static ListNode partition(ListNode head, int x) {
        ListNode start = head;
        ListNode rs = null, re = null;
        ListNode ls = null, le = null;
        ListNode curNode;

        ListNode temp = new ListNode(0);
        temp.next = head;
        while (temp.next != null) {
            if (temp.next.val > x) {
                break;
            }
            temp = temp.next;
        }

        while (temp.next != null) {
            if (temp.next.val <= x) {

                curNode = temp;
                ls = new ListNode(temp.val);
                le = ls;
                while (temp.next != null && temp.next.val <= x) {
                    le.next = temp.next;
                    le = le.next;
                    temp = temp.next;
                }
                if (re != null) {
//                    re.next = temp.next;
//                    temp.next = rs.next;
                }
//                printList(start);
                if (temp.next != null) curNode.next = temp.next;
                printList(temp);
                re = null;
            } else {
                curNode = temp;
                re = new ListNode(temp.val);
                rs = re;
                while (temp.next != null && temp.next.val > x) {
                    re.next = temp.next;
                    re = re.next; // TODO: 21/12/2016 must need next;
                    temp = temp.next;
                }
                if (le != null) {
                    le.next = temp.next;
                    temp.next = ls.next;
                }
                le = null;
                if(temp.next != null) curNode.next = temp.next;
            }
        }
        return start;
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
        int[] array = {1,3,5,6,4,2};
        ListNode input = new ListNode(0);
        ListNode head = input;

        for (int i = 0; i < array.length; i ++) {
            input.next = new ListNode(array[i]);
            input = input.next;
        }
        ListNode res = partition(head.next, 4);
        printList(res);
    }
}
