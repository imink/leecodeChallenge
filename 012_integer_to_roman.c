/* 012 integer to roman */
/* Given an integer, convert it to a roman numeral. */

/* Input is guaranteed to be within the range from 1 to 3999. */

char* string_append(int times, char roman_symbol)
{
    char *string;

    string = malloc(sizeof(char) * times);

    for (i = 0; i < r; i ++) {
        string[i] = roman_symbol;
    }


    return string;
}

char* intToRoman(int num) {
    /* 1, 5, 10, 50, 100, 500, 1000 */
    char roman_symbol[7] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

    while(1) {
        digit = num % 10;

        if (digit = 0) {
            counter ++;
            num = num / 10;
        } else {
            if (digit >= 1 && digit <= 3) {
                sub_string = string_append(digit, symbol)
            }
            else if (digit == 4) {
                temp_array[0] = roman_symbol[0];
                temp_array[1] = roman_symbol[1];
                sub_string = temp_array;
            }
            else if (digit >= 5 && digit <= 8) {
                times = digit - 5;
                sub_string = string_append(times, symbol);
                /* append sub_string to V, L, D */

            }
            else if (digit == 9) {
                temp_array[0] = roman_symbol[0];
                temp_array[1] = roman_symbol[1];
                sub_string = temp_array;
            }
            /* append to string, frome low digits to high digits*/
            strcat(parent_string, sub_string);
        }
    }
}


int int main(void)
{

    return 0;
}
