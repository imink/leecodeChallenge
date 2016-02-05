/* 007 */
/* Reverse digits of an integer. */

/* Example1: x = 123, return 321 */
/* Example2: x = -123, return -321 */

#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#include <limits.h>
#include <stdlib.h>
/**
 *  idea
 *  1. serilise the number into integer array;
 *  2. reverse array, construct the integer by "1000 * x + 100 * y + 10 * z";
 *  3. two points mentioned: 1) check if the reveser integer is exceed the max int; 2) check the reverse number start with zero, get rid of these zeros
 *
 */
int get_length (int number)
{
    int i = !number;
    while (number) {
        i ++;
        number/=10;
    }
    return i;
}
int reverse_integer(int number)
{
    int *table;
    int i, j, m, n;
    int length;

    i = 0;
    if (number == 0) return 0;
    else {
        length = get_length(number);
        table = malloc(sizeof(int) * length );
        length = length - 1;
        while (length >= 0) {
            m = pow(10, length);
            n = number / m;
            if (n == 0) {
                table[i] = 0;
            } else {
                 table[i] = n;
            }
            printf("%d ", table[i]);
            number = number % m;
            i ++;

            /* printf("%d ", table[i]); */
            length --;
        }
    }
    free(table);
    return 0;
}



int main(int args, char** argv)
{
    reverse_integer(-1004);
    return 0;
}


