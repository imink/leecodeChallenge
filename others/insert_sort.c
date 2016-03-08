#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[]) 
{	int n = 4; // length of array
	int temp = 0;
	int array[4] = {3,1,4,2};
	int i,j = 0;	
	for (i = 1; i < n; i ++) {
					
		temp = array[i]; // keep the origin next card that need to be sorted	
		for(j = i; j > 0 && array[j-1] > temp; j --) {
				//swap only if satisfiy the condition 
				array[j] = array[j-1];
		}
		array[j] = temp;
	}

	for (i = 0; i < n; i ++) {
		printf("%d ", array[i]);
	}
	return 0;
}
