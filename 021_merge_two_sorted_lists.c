/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 
void appendList(struct ListNode* oldList,struct ListNode* newList) 
{

    struct ListNode *tempList;
    while (newList) {
        tempList = malloc(sizeof(struct ListNode));
        tempList->val = newList->val;
        //printf("%d\n", newList->val);
        oldList->next = tempList;
        oldList = oldList->next;
        newList = newList->next;
    }
    //printf("%d\n", head->next->val);
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
        
        // append rest of list to the new list
        if (!l1) {
            appendList(mergedList, l2);
            break;
        } 
        if (!l2) {
            appendList(mergedList, l1);
            break;
        }
        
        listNode = malloc(sizeof(struct ListNode));
        
        if (l1->val <= l2->val) {
            listNode->val = l1->val;
            l1 = l1->next;
        } else if(l1->val > l2->val) {
            listNode->val = l2->val;

            l2 = l2->next;
        }
        //printf("sort: %d\n", listNode->val);
        mergedList->next = listNode;
        mergedList = mergedList->next;
    }
    
    return head;
}



