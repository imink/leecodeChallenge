int removeElement(int* nums, int numsSize, int val) {

    int i;

    int index = 0;

    if (numsSize == 1) {

        if (nums[0] == val) {
            nums[0] = NULL;
            return 0;
        } else {
            return 1;
        }

    }

    if (numsSize == 0) {
        return NULL;
    }
    for (i = 0; i < numsSize; i ++) {

        if (nums[i] != val) {

            nums[index] = nums[i];

            index ++;
        }


    }

    return index;

}
