/**
 * https://leetcode.com/problems/the-skyline-problem/
 * Created by imink on 15/02/2017.
 */
import java.util.*;

public class TheSkylineProblem {
    class Interval {
        int left;
        int right;
        int height;
        public Interval(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null || buildings[0] == null) return null;

        // building list
        ArrayList<Interval> buildingList = new ArrayList<Interval>();
        for (int i = 0; i < buildings.length; i ++) {
            Interval item = new Interval(buildings[i][0], buildings[i][1], buildings[i][3]);
            buildingList.add(item);
        }
        return null;
    }
}
