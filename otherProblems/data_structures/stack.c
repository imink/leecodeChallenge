#include <stdlib.h>
#include <stdio.h>


struct typedef Stack 
{
	char c;
	struct Stack *next;

} Stack;


char pop(Stack *stack) 
{
	if (stack != NULL) {
		char item = stack->c;
		stack = stack->next;
		return item;
	}

	return NULL;
}


void push(char item, Stack *stack)
{
	Stack object;
	object->c = item;

	object->next = stack;
	stack = object;
}




int int main(int argc, char const *argv[])
{
	
	return 0;
}