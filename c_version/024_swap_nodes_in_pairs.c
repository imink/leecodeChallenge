/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    int a;
    struct ListNode *initHead;
    initHead = head;
    
    if(!head) {
        return NULL;
    }
    while (1) {
        if (head->next == NULL) {
            break;
        }
        
        a = head->val;
        head->val = head->next->val;
        head->next->val = a;
        if (head->next->next == NULL) {
            break;
        }
        if (head->next->next->next == NULL) {
            break;
        } else {
            head = head->next->next;
        }
    }
    
    return initHead;
}
