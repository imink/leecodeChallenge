import java.util.HashMap;
import java.util.Map;


/**
 * Add and Search Word
 * www.lintcode.com/en/problem/add-and-search-word/
 * http://www.jiuzhang.com/solutions/add-and-search-word/
 * Created by imink on 26/10/2016.
 */


public class LintCode473 {

    class TrieNode {
        HashMap<Character, TrieNode> childNode;
        boolean hasWord;


        public TrieNode() {
            this.hasWord = false;
            this.childNode = new HashMap<Character, TrieNode>();
        }

    }
    // crt a global variable to make sure we can access root all the time
    private TrieNode root;

    public LintCode473() {
        root = new TrieNode();
    }


    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i ++) {
            Character c = word.charAt(i);
            if (!cur.childNode.containsKey(c)) {
                cur.childNode.put(c, new TrieNode());
            }
            cur = cur.childNode.get(c);
        }
        cur.hasWord = true;
    }

    boolean find(String word, int index, TrieNode cur) {
        if (index == word.length()) {
            if (cur.childNode.size() == 0)
                return true;
            else
                return false;
        }

        Character c = word.charAt(index);

        if (cur.childNode.containsKey(c)) {
            // end of the word
            if (index == word.length() - 1 && cur.childNode.get(c).hasWord) {
                return true;
            }
            return find(word, index + 1, cur.childNode.get(c));
        } else if (c == '.') {
            boolean result = false;
            for (Map.Entry<Character, TrieNode> childNode: cur.childNode.entrySet()) {
                if (index == word.length() - 1 && childNode.getValue().hasWord) {
                    return true;
                }

                if (find(word, index + 1, childNode.getValue())) {
                    result = true;
                }
            }
            return result;
        } else {
            return false;
        }
    }


    public boolean search(String word) {

        return find(word, 0, root);
    }

     public static void main(String[] args) {
         LintCode473 obj = new LintCode473();
         obj.addWord("a");
         System.out.println(obj.search("."));
     }

}
