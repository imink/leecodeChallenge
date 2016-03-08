
// Find the index of searched item in a sorted array, time complexity O(logN)
int binarySearch(int x, int a[], int n)
{
	int low,high,mid;
	low = 0;
	high = n - 1;

	while(low <= high){
		mid = (low + high)/2;

		if(x < a[mid])
			high = mid - 1;
		else if(x > a[mid])
			low = mid + 1;
		else 
			return mid;
	}

	return -1;

}