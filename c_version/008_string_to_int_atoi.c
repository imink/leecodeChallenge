/* 008 */
/* mplement atoi to convert a string to an integer. */

/**
 * There might be situations we need to consider:
 * 1. "     123", get rig of the whitespaces, return 123;
 * 2. "123 asdasd", cantains the non numberic char after the sequence of integral numbers, should return the integral numbers;
 * 3. "-123", return -123;
 * 4. "     " or "asdasdasd", should return 0;
 * 5. "99999999999999", that exceeds the max int, should return 0, vice-verser;
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
#include <limits.h>

#define MAX_LEN 100
#define INT_32_DIV10 INT_MAX / 10

int myAtoi (char *str)
{
    int length;
    int i, j = 0;
    /* int m; */
    int ret[MAX_LEN] = {-1};
    int integer = 0;
    int counter = 0;
    bool sign = true;

    length = strlen(str);
    for (i = 0; i < length; i ++) {
        if (str[i] == 32) {
            
        } else {
            if ((str[i] >= 48 && str[i] <= 57) || str[i] == 45 || str[i] == 43) {
                if (str[i] != 45 && str[i] != 43) {
                    ret[j] = str[i] - 48;
                    j ++;
                }

                if (str[i] == 45) {
                     printf("%d ", i); 
                    sign = false;
                }
                
                counter = i + 1;
                if (counter <= length && (str[counter] < 48 || str[counter] > 57)) {
                    break;
                } 
            } else {
                break;
            }
        }


        }

    /* m = j - 1; */
    for (i = 0; i < j; i ++) {
        /* integer = integer + ret[i] * pow(10, m --); */
        printf("%d\n", ret[i]);
        if (integer > INT_32_DIV10 || (integer == INT_32_DIV10 && ret[i] >= 8)) {
            return sign ? INT_MAX : INT_MIN;
        }
        integer = integer * 10 + ret[i];
        printf("%d\n", integer);

    }

    return sign ? integer : integer * -1;
}



int main (int args, char **argv)
{
    /* int n = atoi("asda   -3123123   4   4"); */
    /* printf("%d", INT_32_DIV10); */
    printf("%d", myAtoi("   -04f"));
    return 0;
}
