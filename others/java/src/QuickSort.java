import java.util.Arrays;

/**
 * Created by imink on 25/11/2016.
 */
public class QuickSort {
    public QuickSort() {
    }

    public static void recursiveSort(int[] input, int l, int r) {
        if (l < r) {
            int p = partitionLeft(input, l, r);
            recursiveSort(input, l, p - 1);
            recursiveSort(input, p + 1, r);
        }
    }

    public static void nonRecursiveSort(int[] input, int l, int r) {
        int[] stack = new int[input.length];
        int len = 0;
        stack[len++] = l;
        stack[len++] = r;

        while (len > 0) {
            // TODO: 25/11/2016
            r = stack[--len];
            l = stack[--len];
            System.out.println(r);
            int p = partitionLeft(input, l, r);
            if (p + 1 < r) {
                stack[len++] = p + 1;
                stack[len++] = r;
            }
            if (p - 1 > l) {
                stack[len++] = l;
                stack[len++] = p - 1;
            }
        }
    }


    // return the pivot index
    public static int partitionMid(int[] input, int l, int r) {
        int mid = (l + r) / 2;
        int pivot = input[mid];
        while (mid < r || l < mid) {
            while (mid < r && input[r] >= pivot) {
                r --;
            }
            if (mid < r) {
                // input[r] < pivot
                input[mid] = input[r];
                mid ++;
            }
            while (l < mid && input[l] <= pivot) {
                l ++;
            }
            if (l < mid) {
                input[mid] = input[l];
                mid --;
            }
        }
        input[mid] = pivot;
        return mid;
    }



    public static int partitionLeft(int[] input, int l, int r) {
        int pivot = input[l];
        while (l < r) {
            while (l < r && input[r] >= pivot) {
                r --;
            }
            if (l < r) {
                // input[r] < pivot
                input[l] = input[r];
                l ++;
            }
            while (l < r && input[l] <= pivot) {
                l ++;
            }
            if (l < r) {
                input[r] = input[l];
                r --;
            }
        }
        input[l] = pivot;
        return l;
    }







    public static void main(String[] args) {
        int[] input = {2,1,4,3,10,6,5,7};
        QuickSort.nonRecursiveSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }
}
