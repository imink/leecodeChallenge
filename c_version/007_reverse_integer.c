/* 007 */
/* Reverse digits of an integer. */

/* Example1: x = 123, return 321 */
/* Example2: x = -123, return -321 */

#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>
#include <limits.h>
/**
 *  idea
 *  1. serilise the x into integer array;
 *  2. reverse array, construct the integer by "1000 * x + 100 * y + 10 * z";
 *  3. two points mentioned: 1) check if the reveser integer is exceed the max int; 2) check the reverse x start with zero, get rid of these zeros
 *
 */
int get_length (int x)
{
    int i = !x;
    while (x) {
        i ++;
        x/=10;
    }
    return i;
}
int reverse_integer(int x)
{
    int *table;
    int i, j, m, n;
    int num_of_digit;
    int length;
    bool sign;
    int reverse_num = 0;
    i = 0;
    num_of_digit = get_length(x);
    if (x == 0) return 0;
    else {
        sign = x > 0 ? true: false;
        x = abs(x);
        length = get_length(x);
        table = malloc(sizeof(int) * length );
        length = length - 1;
        while (length >= 0) {
            m = pow(10, length);
            n = x / m;
            if (n == 0) {
                table[i] = 0;
            } else {
                 table[i] = n;
            }
            x = x % m;
            i ++;

            /* printf("%d ", table[i]); */
            length --;
        }
    }

    for (i = 0; i < num_of_digit; i ++) {
        /* printf("%d \n", table[i]); */
        reverse_num = reverse_num + table[i] * pow(10, i);
        if (reverse_num > INT_MAX / 10) return 0;
        /* printf("%d \n", reverse_num); */
    }

    printf("%d ", reverse_num);
    if (!sign) reverse_num = reverse_num * -1;
    free(table);
    return reverse_num;
}



int main(int args, char** argv)
{
    reverse_integer(1534236469);
    return 0;
}


