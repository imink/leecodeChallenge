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



divideLists(struct ListNode** lists, struct lists, int left, int right)
{

    if (left < right) {

        m = (left + right)/2;
        divideLists(lists, left, m);
        divideLists(lists, m + 1, right);
        merge();

    }


}





struct ListNode* mergeKLists(struct ListNode** lists, int listsSize) {

    struct ListNode *head;

    struct ListNode *list;

    head = list;
    divideLists(lists, list, 0, listsSize);




    return head;
}
