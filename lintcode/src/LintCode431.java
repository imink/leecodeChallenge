import java.util.*;

/**
 * Created by imink on 01/11/2016.
 */
public class LintCode431 {
    class UndirectedGraphNode {
             int label;
             ArrayList<UndirectedGraphNode> neighbors;
             UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    class UnionFind {
        HashMap <Integer, Integer> root = new HashMap<Integer, Integer>();

        // constructor
        UnionFind(HashSet<Integer> hashSet)
        {
            for (Integer cur: hashSet) {
                root.put(cur, cur);
            }
        }

        int find(int x)
        {
            int parent = root.get(x);
            while (parent != root.get(parent)) {
                parent = root.get(parent);
            }
            return parent;
        }

        int compressd_find(int x)
        {
            return 0;
        }

        void union(int x, int y)
        {
            int root_x = x;
            int root_y = y;
            if (root_x != root_y) {
                root.put(root_x, root_y);
            }
        }
    }

    List<List<Integer>> print(HashSet<Integer> hashSet, UnionFind uf, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();


        for (int i : hashSet) {
            int root = uf.find(i);
            if (!hashMap.containsKey(root)) {
                hashMap.put(root, new ArrayList<Integer>());
            }

            List<Integer> cur = hashMap.get(root);
            cur.add(i);
            hashMap.put(root, cur);
        }

        for (List<Integer> cur : hashMap.values()) {
            Collections.sort(cur);
            ans.add(cur);
        }

        return ans;


    }
    public List<List<Integer> > connectedSet(ArrayList<UndirectedGraphNode> nodes)
    {
        // Write your code here

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (UndirectedGraphNode now : nodes) {
            hashSet.add(now.label);
            for (UndirectedGraphNode neighbour : now.neighbors) {
                hashSet.add(neighbour.label);
            }
        }
        UnionFind uf = new UnionFind(hashSet);

        for (UndirectedGraphNode now : nodes) {

            for (UndirectedGraphNode neighbour : now.neighbors) {
                int fnow = uf.find(now.label);
                int fneighbour = uf.find(neighbour.label);
                if (fnow != fneighbour) {
                    uf.union(now.label, neighbour.label);
                }
            }
        }

        return print(hashSet, uf, nodes.size());
    }


}
