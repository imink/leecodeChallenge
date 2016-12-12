/**
 * Created by imink on 12/12/2016.
 */
public class Sqrt {
    public int mySqrt(int x) {
        long start = 1;
        long end = x;
        if (x <= 0) return 0;
        while (start + 1 < end) {
            long mid = (start + end) / 2;
            if (x < mid * mid) end = mid;
            else if (x > mid * mid) start = mid;
            else return (int)mid;
        }
        if (x >= end * end) return (int)end;
        else return (int)start;
    }
}
