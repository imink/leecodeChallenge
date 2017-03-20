package sorting;

import java.util.Stack;

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
            while (array[left] <= pivot && left < right) left++;
            while (array[right] >= pivot && left < right) right--;
            swap(left, right);
        }
        // TODO: 16/03/2017 why if here?
        if (array[left] >= pivot) {
            swap(left, end);
        } else {
            left ++;
        }
        // now array[left] is the pivot
        quickSort(start, left - 1);
        quickSort(left + 1, end);
    }

    public int partition(int start, int end) {
        int pivot = array[end];
        int left = start;
        int right = end;
        while (left < right) {
            while (array[left] <= pivot && left < right) left++;
//            array[right] = array[left];
            while (array[right] >= pivot && left < right) right--;
//            array[left] = array[right];
            swap(left, right);
        }
        array[left] = pivot;
        return left;
    }


    public void quikSortItr() {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);

        int left, right, pivot;
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            pivot = partition(left, right);

            if (left < pivot - 1) {
                stack.push(left);
                stack.push(pivot - 1);
            }
            if (right > pivot + 1) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }

    private void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
