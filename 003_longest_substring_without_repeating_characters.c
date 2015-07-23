/**
 * Given a string, find the length of the longest substring 
 * without repeating characters. For example, the longest 
 * substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", 
 * with the length of 1.
 */


/**
 * using hashing map to check if the next one is already in the list
 * once find a repeated char, compute the current length and compare it 
 * to the max previous length.
 * @param   [description]
 * @return   [description]
 */
int lengthOfLongestSubstring(char *s)
{

	int length = s.length;
	int curLength = 0, maxLength = 0;
	char archive[length] = {false};

	int i = 0, j = 0;

	while(s[j++]){

		i = j + 1;
		while(s[i++]){

			if(!archive[s[i]]){
				// not repeated, marked as true
				archive[s[i]] = true; 
				curLength ++; // current length increment 
			} else {
				// found repeated, break traverse,compare with previous max length
				break; // jump out of current loop
			}
		}

		if(curLength > maxLength ) {
			maxLength = curLength;
		}

	}

	return maxLength;

}