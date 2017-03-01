package sorting;

/**
 * Created by imink on 28/02/2017.
 */
public class BubbleSort {
    public int[] BubbleSort(int[] array) {
        for (int i = 0; i < array.length; i ++) {
            for (int j = i + 1;j < array.length; j ++) {
                if (array[i] > array[j]) {
                    //swap
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
