package sorting;

import java.util.Arrays;

/**
 * Created by imink on 28/02/2017.
 */
public class Test {
    public static void main (String[] args) {
        int[] input = new int[]{5,7,3,2,1};
        BubbleSort obj = new BubbleSort();
        QuickSort quickSort = new QuickSort();
        quickSort.array = input;
        MergeSort ms = new MergeSort(input);
        ms.divide(0, input.length - 1);
        InsertSort is = new InsertSort();
//        quickSort.quickSort(0, quickSort.array.length - 1);
        quickSort.quikSortItr();
        ShellSort ss = new ShellSort();
        System.out.println(Arrays.toString(ss.ShellSort(input)));
    }
}
