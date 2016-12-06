import java.util.*;

/**
 * https://leetcode.com/problems/clone-graph/
 * Created by imink on 06/12/2016.
 */
public class CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            List<UndirectedGraphNode> curList = new ArrayList<>();
            List<UndirectedGraphNode> nextList = new ArrayList<>();

            while (true) {
                int len = curList.size() - 1;
                while (curList.size() > 0) {
                    node = curList.get(len);
                    curList.remove(len);
                    len --;
                    System.out.println(node.label);
                    for (int i = 0; i < node.neighbors.size(); i ++) {
                        nextList.add(node.neighbors.get(i));
                    }
                }
                if (nextList.size() == 0) break;
                curList.addAll(nextList);
                nextList = new ArrayList<>();
            }
            return new UndirectedGraphNode(-1);
        }
    }
}
