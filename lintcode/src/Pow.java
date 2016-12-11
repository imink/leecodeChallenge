/**
 * https://leetcode.com/problems/powx-n/
 * Created by imink on 10/12/2016.
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = n * -1;
            return 1.0 / pow(x, n);
        }
        return pow(x, n);
    }

    private double pow(double x, int n) {
        double res = 0;
        if (n == 0) return 1;
//        if (n == 1) return x;
        res = pow(x, n/2);
        if (n % 2 == 0) return res * res;
        else return res * res * x;
    }
}
