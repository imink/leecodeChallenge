package sorting;

/**
 * Created by imink on 01/03/2017.
 */
public class MergeSort {
    public int[] array;

    public MergeSort(int[] array) {
        this.array = array;
    }

    public void divide(int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        divide(start, mid);
        divide(mid + 1, end);
        merge(start, mid, end);
    }

    public void merge(int start, int mid, int end) {
        int left = start;
//        int right = mid + 1;
        while (left <= mid && mid + 1 <= end) {
            // insert sort
            if (array[left] >= array[mid + 1]) {
                int temp = array[mid + 1];
                for (int i = mid; i >= left; i--) {
                    array[i + 1] = array[i];
                }
                // swap
                array[left] = temp;
                mid ++;
            } else {
                left ++;
            }
        }
    }
}
