/**
 *
 *  * Definition for singly-linked list.
 *
 *   * struct ListNode {
 *
 *    *     int val;
 *
 *     *     struct ListNode *next;
 *
 *      * };
 *
 *       */

struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {

    int i = 1;

    int k = 1;

    int j;

    struct ListNode *next;



    next = head->next;

    while(next) {

        next = next->next;

        i ++;


    }



    j = i - n;

    next = head->next;

    while(next) {

        if (j == k) {

            next->next = next->next->next;

            break;


        }

        next = next->next;

        k ++;


    }



    return head;


}
