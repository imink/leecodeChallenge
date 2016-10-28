import java.util.*;

/**
 * Number of Airplanes in the Sky
 * Given an interval list which are flying and landing time of the flight.
 * How many airplanes are on the sky at most?
 * http://www.lintcode.com/en/problem/number-of-airplanes-in-the-sky/
 * http://www.jiuzhang.com/solutions/number-of-airplanes-in-the-sky/
 * Tags: sweep-line
 * Created by imink on 27/10/2016.
 */


 //Definition of Interval:
class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Point {
    int time;
    int flag;

    Point(int t, int f) {
        this.time = t;
        this.flag = f;
    }

    public static Comparator<Point> PointComparator = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            // time is the same, then start is greater than end
            if (o1.time == o2.time) {
                return o1.flag - o2.flag;
            }
            // time different, -1 means descending.
            else return o1.time - o2.time;
        }
    };
}


public class LintCode391 {


    public int countOfAirplanes(List<Interval> airplanes) {
        List<Point> list = new ArrayList<>(airplanes.size() * 2);
        for (Interval i: airplanes) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }

        Collections.sort(list, Point.PointComparator);
        int count = 0, ans = 0;
        for (Point p : list) {
            if (p.flag == 1) count ++;
            else count --;
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
