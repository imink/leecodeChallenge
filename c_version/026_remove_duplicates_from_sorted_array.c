int removeDuplicates(int* nums, int numsSize) {
    int length = 0;
    int j = 0, m = 0;
    int i;
    int last = nums[0];
    int index[3000] = {0};

    for (i = 1; i < numsSize; i ++) {

        if (nums[i] == last) {
            //remove
            index[j] = i;
            j ++;
            length++;
        } else {
            last = nums[i];
            if (j > 0) {
                nums[index[m]] = nums[i];
                m ++;
                printf("nums[i]: %d\n", nums[i]);
                printf("m: %d\n", m);
            }

        }

    }

    printf("%d\n", numsSize - length);
    return numsSize - length;

}



int removeDuplicates(int* nums, int numsSize) {

    int index = 1;

    int i;


    if (numsSize < 2) {

        return numsSize;

    }


    for (i = 1; i < numsSize; i ++) {

        if (nums[i] != nums[i - 1]) {
            nums[index ++] = nums[i];

        }

    }


    return index;




}
