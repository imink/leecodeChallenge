package base;

/**
 * Created by imink on 14/02/2017.
 */
import java.util.List;
import java.util.ArrayList;

public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
