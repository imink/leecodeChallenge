/**
 * Find the position of first char of substring in a string
 */

char *strStr(const char *sub char *string)
{
	if(!*sub) return string;

	char *p1 = (char*) string;
	while(*p1) {
		char *p1Begin = p1, *p2 = (char*)sub;

		// check p1,p2 not null, and p1'char = p2'char 
		while(*p1 && *p2 && *p1 == *p2){
			p1++;
			p2++;
		}
		if(!*p2) return p1Begin; // traverse p2, if it is null, return the begin positon;

		p1 = p1Begin + 1; // pointer increment into next char;

		return NULL;
	}
}