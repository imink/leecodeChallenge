/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */

// notice that the diff between index and sumSize

// Solution 1, merger two sorted array first and find the median, large than O(log(n+m))
double findMedianSortedArraysS1(int *nums1, int nums1Size, int *nums2, int nums2Size) 
{
    // Merge two arrays
    // Slelect the median
    
}


// 堆排序 Heap 排序
double findMedianSortedArraysS2(int *nums1, int nums1Size, int *nums2, int nums2Size)
{

	double median;

	// Condition1 no overlap, O(N)
	if(nums1 = nums2){ 
		// two arrays have the same size
		if(nums1[nums1Size-1] <= nums2[0]){

			median = (nums1[nums1Size1-1] + nums2[0])/2;

			return median;
		}
	} else {
		// different size
		sumSize = nums1 + nums2;
		if(sumSize % 2){
			// even number
			if(nums1Size > nums2Size){
				median = (nums1[sumSize/2 - nums2Size] + nums1[sumSize/2 - nums2Size + 1])/2;				
			} else {
				median = (nums2[sumSize/2 - nums1Size] + nums2[sumSize/2 - nums1Size + 1])/2;
			}
		} else {
			// odd number
			if(nums1Size > nums2Size){
				median = nums1Size[(sumSize+1)/2 - nums2Size];
			} else {
				median = nums2Size[(sumSize+1)/2 - nums1Size];				
			}
		}

		return median
	} 



	// Condition2 has overlap

}
