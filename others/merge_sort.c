#include <stdlib.h>
#include <stdio.h>

void merge_sort (int array[], int left, int right)
{
    int length = right - left + 1;
	int m = left + length/2;
	int temp = 0;
	if(length <= 2) {
		if(array[left] > array[right]) {
			// swap for asceding sort
			temp = array[right];
			array[right] = array[left];
			array[left] = temp;
		}

	} else {

		printf("middle is %d", m);
		merge_sort(array, left, m-1);
		merge_sort(array, m, right);
	}

//	printf("\n m is %d, left is %d, right is %d", m, left, right);



}

int main (int argc, char *argv[]) {
	int i = 0;
	int array[7] = {3,2,4,1,6,9,7};

	merge_sort(array, 0, 6);
	printf("\nsorted array is:");
	for (i = 0; i < 7; i ++) {
		printf(" %d", array[i]);
	}


	return 0;
}
