/**
 * Created by imink on 25/10/2016.
 */
import java.util.*;


public class Trie {
    class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

        boolean hasWord;

        // TODO: 25/10/2016
        public TrieNode() {

        }

        public TrieNode(char c) {
            this.c = c;
        }
    }
    private TrieNode root;

    public Trie() {
        // second constructor
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = root.children;
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < wordArray.length; i ++) {
            char curChar = wordArray[i];
            if (curChildren.containsKey(curChar)) {
                cur = curChildren.get(curChar);
            } else {
                TrieNode newNode = new TrieNode(curChar);
                curChildren.put(curChar, newNode);
                cur = newNode;
            }
            curChildren = cur.children;
            if (i == wordArray.length - 1) {
                cur.hasWord = true;
            }
        }
    }

    public boolean search(String word) {
        if (searchWordNodePos(word) == null) {
            return false;
        } else if (searchWordNodePos(word).hasWord) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        if (searchWordNodePos(prefix) == null) {
            return false;
        } else  return true;
    }

    public TrieNode searchWordNodePos(String s) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode cur = null;
        char[] sArray = s.toCharArray();

        for (int i = 0; i < sArray.length; i++) {
            char c = sArray[i];
            if (children.containsKey(c)) {
                cur = children.get(c);
                children = cur.children;
            } else {
                return null;
            }
        }

        return cur;
    }

    public static void main (String[] args) {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("dog","dad","dgdg","can","again"));
        char[][] input = {{'d','o','a','f'},{'a','g','a','i'},{'d','c','a','n'}};

        Trie trie = new Trie();

        for (int i = 0; i < words.size(); i ++) {
            trie.insert(words.get(i));
        }

        if (trie.search("doga")) {
            System.out.println("true");
        }
    }
}
