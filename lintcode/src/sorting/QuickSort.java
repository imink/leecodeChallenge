package sorting;

/**
 * Created by imink on 28/02/2017.
 */

public class QuickSort {
    public int[] array;

    public void quickSort(int start, int end) {
        if (start >= end) return;
        int pivot = array[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (array[left] <= pivot && left < right) left ++;
            while (array[right] >= pivot && left < right) right --;
            swap(left, right);
        }
        if (array[left] >= array[end]) {
            swap(left, end);
        } else {
            left ++;
        }
        quickSort(start, left - 1);
        quickSort(left + 1, end);
    }

    private void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public int[] quickSortItr(int[] array) {
        return array;
    }
}
