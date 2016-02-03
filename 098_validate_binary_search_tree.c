/* 098 */
/* Given a binary tree, determine if it is a valid binary search tree (BST). */

/* Assume a BST is defined as follows: */

/* The left subtree of a node contains only nodes with keys less than the node's key. */
/* The right subtree of a node contains only nodes with keys greater than the node's key. */
/* Both the left and right subtrees must also be binary search trees. */

#include <stdio.h>
#include <stdbool.h>
#include "base/BST.h"

bool isValidBST (SearchTree *root)
{
    if (root == NULL) {
        return 0;
    }
    if (root != NULL) {
        if (root->right != NULL && root->left != NULL) {
            if (root->left->key > root->right->key) {
                return 0; // false
            }
        }
        if (root->right != NULL) {
           return isValidBST(root->right);
        }
        if (root->left != NULL) {
           return isValidBST(root->left);
        }
    } return 1;
}


int main(int args, char **argv)
{

    return 0;
}
