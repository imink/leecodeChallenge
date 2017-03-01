package sorting;

/**
 * Created by imink on 01/03/2017.
 */
public class InsertSort {
    public int[] InsertSort(int[] array) {
        for (int i = 1; i < array.length; i ++) {
            if (array[i] < array[i - 1]) {
                int j = i - 1;
                int temp = array[i];
                // traverse to most left that large than the cur
                while (j >= 0 && temp < array[j]) {
                    // move the left one step right, leave a blank for temp
                    array[j + 1] = array[j];
                    j --;
                }
                // 最差情况 j = -1, 所以需要j + 1
                array[j + 1] = temp;
            }
        }
        return array;
    }
}
