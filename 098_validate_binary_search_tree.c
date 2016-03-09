/* 098 */
/* Given a binary tree, determine if it is a valid binary search tree (BST). */

/* Assume a BST is defined as follows: */

/* The left subtree of a node contains only nodes with keys less than the node's key. */
/* The right subtree of a node contains only nodes with keys greater than the node's key. */
/* Both the left and right subtrees must also be binary search trees. */

/**
 * some ideads:
 * 1. first we need to total understande there arae manny ways to traverse a node, preorder, postorder, inorder;
 * 2. try to find the feature pattern of BST, that is each node value is within the value of lastLeft value and lastRight value that comes from last node;
 * 3. implement the idea, then we got the O(n) time complexity and O(n) space complexity;
 *
 */
#include <stdio.h>
#include <stdbool.h>
#include "base/BST.h"


bool checkValid(struct TreeNode *node, bool left, bool right, int lastLeft, int lastRight)
{
    if (!node) {
        return 1;
    }

    int val = node->val;

    if (( left || val > lastLeft) && (right || val < lastRight)) {
        // if (node->left != NULL) {
        //     return checkValid(node->left, lastLeft, val);
        // }
        // if (node->right != NULL) {
        //     return checkValid(node->right, val, lastRight);
        // }
        // if (node->right == NULL && node->left == NULL) {
        //     return 1;
        // }
        // still get confused with this line, what exact return condition1 && condition 2 mean?
        return checkValid(node->left, left, true, lastLeft, val) && checkValid(node->right, true, right, val, lastRight);

    } else {
        return 0;
    }

}


bool isValidBST(struct TreeNode* root) {
    return checkValid(root, false, false, 0, 0);
}


int main(int args, char **argv)
{

    return 0;
}
