/**
 * Bugs: 1. not malloc efficiently, root is not assigned with char, 
 * carefully deal with each list next
 */



#include <stdlib.h>
#include <stdio.h>

typedef struct LinkedList 
{
    struct LinkedList *next;
    char c;   

} stringList;

int main () 
{   
    char string[5] = "apple";
    int i = 0;
    // set up a new linked list
    stringList *root;
    root = (stringList *)malloc(sizeof (stringList));
    root->next = NULL;
    // store the header of list
    stringList *temp = root; 
    // init with string
    while (string[i]) {
        // check if current is the end of list
        stringList *nextNode = (stringList *)malloc(sizeof (stringList));
        root->next = nextNode;
        nextNode->c = string[i];
        // void point to null 
        // very critical step
        nextNode->next = NULL;
        root = root->next;
        i ++;  
        printf("%d\n", i);     
    }
    root = temp;
    i = 0;
    while (1) {
        if (!root->next) {
            break;
        }
        root = root->next;
 

        printf("%c\n", root->c);
        i ++;
    }



    

    
    



}

