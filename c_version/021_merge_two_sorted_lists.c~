/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 
struct ListNode* copyList(struct ListNode* list) 
{
    struct ListNode *newList;
    struct ListNode *head;
    struct ListNode *tempList;
    head = newList;
    while (list) {
        tempList = malloc(sizeof(struct ListNode));
        tempList->val = list->val;
        //printf("%d\n", list->val);
        newList->next = tempList;
        newList = newList->next;
        list = list->next;
    }
    //printf("%d\n", head->next->val);
    return newList;
}
 
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *head, *mergedList;
    struct ListNode *listNode;

    if (!l1) {
        return l2;
    } 
    
    if (!l2) {
       return l1; 
    }

    head = mergedList;
    while (l1 || l2) {
        listNode = malloc(sizeof(struct ListNode));
        
        
        // append rest of list to the new list
        if (!l1) {
            mergedList->next = l2;
            break;
        } 
        if (!l2) {
            mergedList->next= l1;
            break;
        }
        
        
        if (l1->val <= l2->val) {
            listNode->val = l1->val;
            l1 = l1->next;
        } else if(l1->val > l2->val) {
            listNode->val = l2->val;

            l2 = l2->next;
        }
       
        mergedList->next = listNode;
        mergedList = mergedList->next;
    }
    
    return head;
}



