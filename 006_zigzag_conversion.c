/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

char* zigzag_convertion(char *str, int rows)
{
    int i, j, m;
    int loop_rount, loop_char_num;
    int length, remainder, column;
    char *table;
    length = sizeof(str);
    loop_count = 1 + rows - 2;
    loop_char_num = rows + rows - 2;
    m = sizeof(str) / loop_char_num; 

    remainder = length % loop_char_num;

    if (remainder <= rows) {
        column = m * loop_char_num + 1;
    } else {
        column = m * loop_char_num + remainder - rows;
    }

    if ((table = malloc(sizeof(char) * column)) == NULL ) {
       
    } 

    for ( i = 0; i < column; i ++) {
        if ((table[i] = malloc( sizeof(char) * rows)) == NULL) {
        }
    }
    
    for ( i = 0; i < column; i ++) {
        if (i < loop_count) {
                loop_num = i;
        } else {
                loop_num = i % loop_count;
        }

        if (loop_num == 0) {
            for ( j = rows - 1; j >= 0; j --) {
                table[i][j] = str[n];
                n ++;
            }
        } else {
            table[i][loop_num] = str[n];
            n ++;
        }
        
        

    }

    

}
