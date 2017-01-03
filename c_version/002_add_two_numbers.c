/**
 * 
 * 
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


/**
 * 1. Reverse two list
 * 2. Add each node
 */


/**
 * 1. if it has a interval > 0, add it to the previous node
 */
typedef struct ListNode *ListNode;

struct ListNode
{
	int value;
	ListNode *next;
		/* data */
};





ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) 
{

	
	int sum = 0;
	int interval = 0;
	while(l1->next && l2->next){
		
		sum = l1->next + l2->next;

		l1 = l1->next;
		l2 = l2->next;


	}


}


ListNode* compositeNewList(sum)
{
	ListNode* list;

	int	interval = sum/10;





}

