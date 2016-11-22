import com.sun.org.apache.xalan.internal.xsltc.dom.ArrayNodeListIterator;

import java.util.*;

/**
 * Created by imink on 22/11/2016.
 */
public class GraphValidTree {
    // define the union find set
    class UnionFindSet {
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();

        // make sure init father to be unique
        UnionFindSet(int n) {
            for (int i = 0; i < n; i ++) {
                father.put(i, i);
            }
        }


        // dig out the root of uf
        int find(int x) {
            int parent = x;
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }

        int compressed_find(int x) {
            // get the root
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            // link every key to the root.
            int temp = -1;
            int fa = father.get(x);
            while (fa != father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }

            return parent;
         }

        void union(int x, int y) {
            // get the root to make sure no same root
            int x_root = find(x);
            int y_root = find(y);
            if (x_root != y_root) {
                father.put(x_root, y_root);
            }
        }
    }




    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if (n - 1 != edges.length) {
            return false;
        }

        UnionFindSet ufs = new UnionFindSet(n);

        for (int i = 0; i < edges.length; i ++) {
            if (ufs.compressed_find(edges[i][0]) == ufs.compressed_find(edges[i][1])) {
                return false;
            }
            ufs.union(edges[i][0], edges[i][1]);
        }
        return true;
    }


}
