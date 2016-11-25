import java.util.Arrays;

/**
 * Created by imink on 25/11/2016.
 */
public class BubbleSort {

    private int[] input;

    public BubbleSort(int[] input) {
        this.input = input;
    }

    public int[] sort() {
        boolean swap;
        int[] input = this.input;
        for (int i = 0; i < input.length; i ++) {
            swap = false;
            for (int j = i + 1; j < input.length; j ++) {
                if (input[i] > input[j]) {
                    swap = true;
                    swap(input, i, j);
                }
            }
            if (!swap) {
                break;
            }
        }
        return input;
    }

    void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = {2,4,1,7,8};
        BubbleSort bubbleSort = new BubbleSort(input);
        System.out.println(Arrays.toString(bubbleSort.sort()));
    }
}
