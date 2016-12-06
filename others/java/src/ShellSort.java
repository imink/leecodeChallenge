import java.util.Arrays;

/**
 * Created by imink on 26/11/2016.
 */
public class ShellSort {

    public static void sort(int[] input) {
        int gap = input.length / 2;
        while (gap > 0) {
            for (int i = gap; i < input.length; i ++) {
                for (int j = i; j > 0; j = j - gap) {
                    if (input[j - gap] > input[j]) {
                        swap(input, j, j - gap);
                    } else {
                        break;
                    }
                }
            }
            gap = gap / 2;
        }
    }

    public static void swap(int[] input,int i,int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }


    public static void main(String[] args) {
        int[] input = {2,1,4,3,10,6,5,7};
        ShellSort.sort(input);
        System.out.println(Arrays.toString(input));
    }
}
