#include <stdio.h>
#include <stdlib.h>

void quick_sort(int array[], int left, int right)
{
    int pivot;
    int i, j, temp;

    if (left < right) {
        pivot = left;
        i = left;
        j = right;
        while (i < j) {
            while(array[i] <= array[pivot] && i < right) i++;
            while(array[j] > array[pivot] && j > left) j--;
            // only condition satisfied can execute, or i = j,
            // jump out of while loop
            if(i < j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

        temp = array[pivot];
        array[pivot] = array[j];
        array[j] = temp;

        quick_sort(array, left, j - 1); // left half side
        quick_sort(array, j + 1, right); // right half side


    }
}




int main (int argc, char *argv[])
{
	int i = 0;
	int array[10] = {2, 4, 3, 8, 21, 17, 23, 51, 12, 13};
	quick_sort(array, 0, 9);
	printf("Sorted Array:");
	for (i = 0; i < 10; i ++) {
        printf(" %d", array[i]);
	}

	return 0;

}
