struct Stack {
    int value;
    struct Stack *next;
    struct Stack *last;
};


bool isValid(char* s) {
    struct Stack *stack;
    struct Stack *next;
    struct Stack *temp;
    
    int length = 0;
    
    stack = malloc(sizeof(struct Stack));
    // 40:41 (), 123:125{},  91:93 []
    
    if((*s == 41 || *s == 125 || *s == 93) && length == 0) {
        return false;
    }    
    
    

    while (*s != '\0') {
        if(*s == 40 || *s == 123 || *s == 91) {
            next = malloc(sizeof(struct Stack));
            next->value = *s;
            stack->next = next;
            temp = stack;
            stack = stack->next;
            stack->last = temp;
            length ++;
        } else if (*s == 41 && stack->value == 40) {
            stack = stack->last;
            stack->next = NULL;
            length --;
            
            
        } else if ((*s == 125 || *s == 93) && stack->value == *s - 2) {
            stack = stack->last;
            stack->next = NULL;
            length --;
            printf("%d\n", length);
        } else {
            return false;
        }
        

        
        printf("%d\n", stack->value);
        
        s ++;
    }
    
    
    if(length == 0) {
        return true;
    } 
    
    return false;
    
}
