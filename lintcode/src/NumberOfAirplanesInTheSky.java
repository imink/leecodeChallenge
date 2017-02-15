import java.util.*;
import java.util.List;

/**
 * Number of Airplanes in the Sky
 * Given an interval list which are flying and landing time of the flight.
 * How many airplanes are on the sky at most?
 * http://www.lintcode.com/en/problem/number-of-airplanes-in-the-sky/
 * http://www.jiuzhang.com/solutions/number-of-airplanes-in-the-sky/
 * Tags: sweep-line
 * Created by imink on 27/10/2016.
 */


public class NumberOfAirplanesInTheSky {
    //Definition of Interval:
    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Pointer {
        int time;
        int flag;
        Pointer(int t, int f) {
            this.time = t;
            this.flag = f;
        }
        public static Comparator<Pointer> PointerComparator = new Comparator<Pointer>() {
            @Override
            public int compare(Pointer o1, Pointer o2) {
                if (o1.time == o2.time) {
                    return o1.flag - o2.flag;
                } else {
                    return o1.time - o2.time;
                }
            }
        };
    }
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        int counter = 0;
        int ans = 0;
        ArrayList<Pointer> pointerList = new ArrayList<Pointer>();
        for (Interval i : airplanes) {
            pointerList.add(new Pointer(i.start, 1));
            pointerList.add(new Pointer(i.end, 0));
        }
        Collections.sort(pointerList, Pointer.PointerComparator);

        for (Pointer p : pointerList) {
            if (p.flag == 1) counter ++;
            else counter --;
            ans = Math.max(ans, counter);
        }

        return counter;
    }
}
