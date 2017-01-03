/**
 * 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
#include<stdio.h>
#include<stdlib.h>

#define PRIME 271



/**
 * Traditional method
 * @param  nums    [description]
 * @param  numSize [description]
 * @param  target  [description]
 * @return         [description]
 */
int* twoSum0(int* nums, int numSize, int target)
{
	if((numbers == NULL) | numSize < 2){
		return NULL;
	}

	int index1, index2;

	int* ret = (int*)malloc(sizeOf(int)*2);

	if(index1 = 0; index1 < numSize; index1 ++){
		for(index2 = index1 + 1; index2 < numSize; index2  ++){
			
			int sum_tmp = nums[index1] + nums[index2];

			if(sum_tmp == target){
				
				ret[0] = index1 + 1;
				ret[1] = index2 + 1;
				return ret;
			}
		}
	}

	return NULL;
}


int* twoSum1(int* nums. int numSize, int target) 
{
	
}










