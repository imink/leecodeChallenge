/**
 * Created by imink on 20/02/2017.
 */
import base.Interval;

import java.util.*;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 1) {
            return intervals;
        }
        // ascending by start point
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> res = new LinkedList<>();
        int s = intervals.get(0).start;
        int e = intervals.get(0).end;
        for (Interval item: intervals) {
            // only compare with the last node
            if (item.start <= e) {
                e = Math.max(item.end, e);
            } else {
                res.add(new Interval(s, e));
                s = item.start;
                e = item.end;
            }
        }
        res.add(new Interval(s, e));
        return res;
    }
}
