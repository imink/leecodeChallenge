/* 009 */
/* Determine whether an integer is a palindrome. Do this without extra space. */
/* max int is 2147483647, min int is -2147483648 */
#include <stdbool.h>
#include <stdlib.h>
#include <stdio.h>
#include <limits.h>

#define INT_32_DIV10 INT_MAX / 10
bool isPalindrome(int x)
{
    int reverse_int = 0;
    int z;
    int y;
    bool sign;

    if (x == INT_MIN) {
        return false;
    }

    if (x < 0) {
        return false;
    } else {
        z = x;
    }

    printf("%d\n", z);

    while(1) {
        if (x < 10) {
            if (reverse_int > INT_32_DIV10 || (reverse_int == INT_32_DIV10 && x >= 8)) {
                return 0;
            }
            reverse_int = reverse_int * 10 + x;
            break;
        }
        y = x % 10;
        x = x / 10;
        reverse_int = reverse_int * 10 + y;
        printf("%d\n", reverse_int);

    }
    printf("%d\n", reverse_int);
    if (reverse_int == z) {
        return true;
    } else {
        return false;
    }
}

int main(int argc, char const* argv[])
{
    printf("%d\n", isPalindrome(-2147447412));
    
    return 0;
}
