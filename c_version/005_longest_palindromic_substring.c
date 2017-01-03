/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * palindromic string is a string that read the same backwards and 
 * farwards, e.g. "aba" "cabac"
 */
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

#define MAX_LEN 1000




bool check_palindorme(char *s, int head, int tail)
{
	int length, h, t, m;
	length = tail - head;
	h = head - 1;
	t = tail - 1;

	if(length%2) {
		m = (length + 1)/2;
	} else {
		m = length/2;
	}

	while(1) {

		if(h == t == m) {
			return true;
		}


		if(s[h] == s[t]) {
			h --;
			t --;
		} else {
			break;
		}
	}

	return false;
}
/**
 * 
 */
char* longest_palindrome_substring_s1(char* s) 
{
	char win_list[MAX_LEN] = 0;
	char matrix[MAX_LEN][MAX_LEN] = 0;
	char count[MAX_LEN] = 0;
	int i,j,m,head, tail, length;
	int diff = 0;

	for(i = 0; i < sizeof(s); i ++) {
		count[s[i]] ++;
		matrix[s[i]][count[s[i]]] = i + 1;
	}   

	for(i = 0; i < MAX_LEN; i ++) {
		if(matrix[s[i]][1] != 0) {
			for(j = 1; j <= count[s[i]]; j ++) {
				for(m = j; m <= count[s[i]]; m ++) {
					head = matrix[s[i]][j];
					tail = matrix[s[i]][m];
					if(check_palindorme(s, head, tail)) {
						length = tail - head;
						if(win_list[s[i]] < length) {
							win_list[s[i]] = length;
						}
					}				
				}
			}
		}
	}
}


int int main(int argc, char const *argv[])
{
	/* code */
	char *s = "asdasdasd";

	longest_palindrome_substring_s1(s);
	
	return 0;
}

