import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by imink on 26/10/2016.
 */
public class WordSearchII {
    class TrieNode {
        String s;
        boolean hasWord;
        HashMap<Character, TrieNode> childNode;

        public TrieNode() {
            hasWord = false;
            childNode = new HashMap<Character, TrieNode>();
            s = "";
        }
    }

    class TrieTree {
        TrieNode root;

        public TrieTree(TrieNode trieNode) {
            root = trieNode;
        }

        public void insert(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                if (!cur.childNode.containsKey(s.charAt(i))) {
                    // new char, then insert to child (char, node) pair
                    cur.childNode.put(s.charAt(i), new TrieNode());
                }
                // already exists, then go down
                cur = cur.childNode.get(s.charAt(i));
            }
            cur.s = s;
            cur.hasWord = true;
        }

        public boolean find(String s) {
            // find from root position
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                if (!cur.childNode.containsKey(s.charAt(i))) {
                    return false;
                }
                cur = cur.childNode.get(s.charAt(i));
            }
            // TODO: 26/10/2016 这里比较精髓, 不同判断是否到最后, 直接返回最后的hasWord
            return cur.hasWord;
        }

    }

    // four direction of the centre node
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    public void search(char[][] matrix, int x, int y, TrieNode root, ArrayList<String> ans) {

        //
        if (root.hasWord) {
            if (!ans.contains(root.s)) {
                ans.add(root.s);
            }
        }
        // check all the edge conditions
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] == 0 || root == null)
            return;
        if (root.childNode.containsKey(matrix[x][y])) {
            for (int i = 0; i < 4; i++) {
                char curChar = matrix[x][y];
                // mark as visited, so we wont access the same char only for next time
                matrix[x][y] = 0;
                search(matrix, x + dx[i], y + dy[i], root.childNode.get(curChar), ans);
                // restore the current n    ode
                matrix[x][y] = curChar;
            }
        }
    }

    public ArrayList<String> wordSearchII(char[][] matrix, ArrayList<String> words) {
        ArrayList<String> ans = new ArrayList<String >();

        TrieTree trieTree = new TrieTree(new TrieNode());

        for (String word: words) {
            trieTree.insert(word);
        }

        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[i].length; j ++) {
                search(matrix, i, j, trieTree.root, ans);
            }
        }

        return ans;
    }
}
