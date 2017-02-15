import java.util.*;

/**
 * Created by imink on 23/10/2016.
 * Code modified from http://wxx5433.github.io/building-outline.html
 */
public class BuildingOutline {
    class Edge implements Comparable<Edge> {
        int height;
        int index;
        boolean isHead;

        public Edge(int index, int height, boolean isHead) {
            this.index = index;
            this.height = height;
            this.isHead = isHead;
        }

        @Override
        public int compareTo(Edge another) {
            if (this.index != another.index) {
                return Integer.compare(this.index, another.index);
            }
            if (this.isHead && another.isHead) {
                return Integer.compare(another.height, this.height);
            }
            if (!this.isHead && !another.isHead) {
                return Integer.compare(this.height, another.height);
            }
            return this.isHead ? -1 : 1;
        }
    }

    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (buildings == null || buildings.length == 0) {
            return result;
        }

        Edge[] edges = new Edge[buildings.length * 2];

        for (int i = 0; i < buildings.length; i ++) {
            edges[i * 2] = new Edge(buildings[i][0], buildings[i][2], true);
            edges[i * 2 + 1] = new Edge(buildings[i][1], buildings[i][2], false);
        }

        Arrays.sort(edges);
        // descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                buildings.length, Collections.<Integer>reverseOrder()
        );
        int prevIndex = -1;
        int prevHeight = -1;

        for (Edge edge: edges) {
            if (edge.isHead) {
                if (pq.isEmpty() || edge.height > pq.peek()) {
                    if (prevIndex != -1) {
                        ArrayList<Integer> newResults = new ArrayList<>();
                        newResults.add(prevIndex);
                        newResults.add(edge.index);
                        newResults.add(prevHeight);
                        result.add(newResults);
                    }
                    prevHeight = edge.height;
                    prevIndex = edge.index;
                }
                pq.add(edge.height);
            } else {
                pq.remove(edge.height);
                if (pq.isEmpty() || edge.height > pq.peek()) {
                    if (prevIndex != -1) {
                        ArrayList<Integer> newResults = new ArrayList<>();
                        newResults.add(prevIndex);
                        newResults.add(edge.index);
                        newResults.add(edge.height);
                        result.add(newResults);
                    }
                    if (pq.isEmpty()) {
                        prevIndex = -1;
                    } else {
                        prevIndex = edge.index;
                        prevHeight = pq.peek();
                    }
                }
            }
        }
        return result;
    }

}
