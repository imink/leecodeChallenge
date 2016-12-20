/**
 * Created by imink on 18/12/2016.
 */
public class HammingDistance {
    public static int hammingDistance(int a, int b) {
        int k = 0;
        k = a ^ b;
        int sum = 0;
        int t = requiredbits(k); //it returns the required no. of bits to represent k in binary
        int[] arr = new int[k];

        for (int f = t - 1; f >= 0; f--) //in this loop we are converting the no. k into binary
        {
            arr[f] = k % 2;
            k = k / 2;
        }

        for (int r = 0; r < t; r++) // here counting number of 1's in the binary representation of k
        {
            if (arr[r] == 1)
                sum++;
        }
        return sum;
    }

    public static int requiredbits(int w) {
        int i = 0;
        while ((2 << i) <= w)
            i++;
        i++;
        return i;
    }

    public static void main(String args[]) throws Exception {

        int a = 3, b = 2;
        System.out.println("hamming distance between " + a + " and " + b + " is " + hammingDistance(a, b));
    }
}
