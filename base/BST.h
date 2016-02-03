#ifndef _BST_H_
#define _BST_H_

struct TreeNode;
typedef struct TreeNode SearchTree;


*SearchTree insert(SearchTree *t, int key);

struct TreeNode
{
    int key;
    SearchTree *right;
    SearchTree *left;
};


#endif /* TreeNode */

