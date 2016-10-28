/**
 * Find the Weak Connected Component in the Directed Graph
 * http://www.lintcode.com/en/problem/find-the-weak-connected-component-in-the-directed-graph/
 * http://www.jiuzhang.com/solutions/find-the-weak-connected-component-in-the-directed-graph/
 * Created by imink on 28/10/2016.
 */

import java.util.*;


public class LintCode432 {
    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    }

    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();

        UnionFind(HashSet<Integer> hashSet) {
            for (Integer now : hashSet) {
                father.put(now, now);
            }
        }

        int find(int x) {
            int parent = father.get(x);
            // only point to itself can be seen as parent.
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }

        int compressed_find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            // now parent is root

            int temp = -1;
            int fa = father.get(x);
            while (fa != father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }

            return parent;
        }

        void union (int x, int y) {
            int fa_x = find(x);
            int fa_y = find(y);
            if (fa_x != fa_y) {
                father.put(fa_x, fa_y);
            }
        }

    }


    List<List<Integer>> print(HashSet<Integer> hashSet, UnionFind uf, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List <Integer>>();

        for (int i : hashSet) {
            int fa = uf.find(i);
            if (!hashMap.containsKey(fa)) {
                hashMap.put(fa, new ArrayList<Integer>());
            }
            // TODO: 28/10/2016 simplify those?
            List <Integer> now = hashMap.get(fa);
            now.add(i);
            hashMap.put(fa, now);
        }

        for (List<Integer> now : hashMap.values()) {
            Collections.sort(now);
            ans.add(now);
        }

        return ans;
    }

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // convert the directedGraphNodes to the hashSet
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(DirectedGraphNode now : nodes){
            hashSet.add(now.label);
            for(DirectedGraphNode neighbour : now.neighbors) {
                hashSet.add(neighbour.label);
            }
        }

        // generate the unionFindSet
        UnionFind uf = new UnionFind(hashSet);



        for(DirectedGraphNode now : nodes){

            for(DirectedGraphNode neighbour : now.neighbors) {
                int fnow = uf.find(now.label);
                int fneighbour = uf.find(neighbour.label);
                // check two set share the same parent
                if(fnow!=fneighbour) {
                    uf.union(now.label, neighbour.label);
                }
            }
        }


        return print(hashSet , uf, nodes.size());
    }


}
