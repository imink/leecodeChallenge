import java.util.Arrays;

/**
 * Created by imink on 25/11/2016.
 */
public class InsertSort {


    public InsertSort() {

    }

    // always maintain a sorted sub array
    public static void sort(int[] input) {
        int temp = input[0];
        for (int i = 1; i < input.length; i ++) {
            // only happen once
            if (input[i] < input[i - 1]) {
                // temp for swap
                temp  = input[i];
                // boundary index, left of this is sorted
                int j = i - 1;
                // use loop to find the one smaller than current
                while (j >=0 && temp < input[j]) {
                    // TODO: 25/11/2016 后面被前面赋值
                    input[j + 1] = input[j--];
                }
                // 最后一次赋值
                input[j + 1] = temp;
            }

        }
    }



    public static void main(String[] args) {
        int[] input = {2,1,4,3,10,6,5,7};
        InsertSort.sort(input);
        System.out.println(Arrays.toString(input));
    }
}
