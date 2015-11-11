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
    // store the header of list
    stringList *temp = root; 
    // init with string
    while (string[i]) {
        // check if current is the end of list
        while (root->next != NULL) {
            root = root->next;
        }

        stringList *nextNode = (stringList *)malloc(sizeof (stringList));
        nextNode->c = string[i];
        root->next = nextNode;
        i ++;       
        printf("%c ", root->c);
    }


    root = temp;
    while (root->next != NULL) {
        printf("ok");
        printf("%c ", root->c);
        root = root->next;
    }

    

    
    



}

