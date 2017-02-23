/**
 * https://leetcode.com/problems/partition-list/
 * Created by imink on 21/12/2016.
 */
import base.ListNode;

public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.val<x) {
                curr1.next = head;
                curr1 = curr1.next;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
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
        int[] array = {1,4,3,2,5,2};
        ListNode input = new ListNode(0);
        ListNode head = input;

        for (int i = 0; i < array.length; i ++) {
            input.next = new ListNode(array[i]);
            input = input.next;
        }
        ListNode res = partition(head.next, 3);
        printList(res);
    }
}
