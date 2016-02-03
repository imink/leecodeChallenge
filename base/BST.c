#include "BST.h"
#include <stdio.h>
#include <stdlib.h>

SearchTree* insert(SearchTree *t, int key)
{
    if (t == NULL) {
        // create the tree if null
        t = malloc(sizeof (struct TreeNode));
        if (t == NULL) {
            // malloc error no space
        } else {
            t->key = key;
            // becarefull with the equal and true equal
            t->right = t->left = NULL;
        }

    }

    // why t->left = insert()
    else
    if (key < t->key) {
        t->left = insert(t->left, key);
    }
    else
    if (key > t->key) {
        t->right = insert(t->right, key);
    }
    // the last situation is key is already exitst, we do nothing.
    return t;
}
