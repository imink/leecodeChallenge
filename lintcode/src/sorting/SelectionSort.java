package sorting;

/**
 * Created by imink on 01/03/2017.
 */
public class SelectionSort {
    // 直接和右边最小值调换
    public SelectionSort(int[] array) {
        int i, j, min, temp;
        for (i = 0; i < array.length; i ++) {
            min = i;
            // find the minimum of the left ones
            for (j = i + 1; j < array.length; j ++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            // swap the current with minimum
            temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }
}
