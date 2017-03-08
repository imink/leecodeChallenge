package sorting;

/**
 * Created by imink on 06/03/2017.
 */
public class ShellSort {
    public int[] ShellSort(int[] array) {
        int left = 0;
        int right = 0;
        int interval = 0;
        int temp = 0;
        for (interval = array.length / 2; interval >= 1; interval /= 2) {
            for (right = interval; right < array.length; right++) {
                temp = array[right];
                left = right - interval;
                while (left > 0 && temp < array[left]) {
                    array[left + interval] = array[left];
                    left -= interval;
                }
                array[left + interval] = temp;
            }
        }
        return array;
    }
}
