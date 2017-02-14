import java.util.*;

/**
 * https://leetcode.com/problems/clone-graph/
 * Created by imink on 06/12/2016.
 */
import base.UndirectedGraphNode;

public class CloneGraph {
    private HashMap<Integer, UndirectedGraphNode> hashMap = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;

        if (hashMap.containsKey(node.label)) {
            return hashMap.get(node.label);
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        hashMap.put(newNode.label, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor));
        }
        return newNode;
    }
}
