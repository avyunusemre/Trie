package sozluk;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    /**
     * Insert a word into trie.
     * @param word
     */
    public void insert(String word) {
        Node currentNode = root;
        char[] arr = word.toCharArray();
        for (char currentChar : arr) {
            if (!currentNode.children.containsKey(currentChar)) {
                currentNode.children.put(currentChar, new Node());
            }
            currentNode = currentNode.children.get(currentChar);
        }
        currentNode.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     * @param word
     * @return true or false.
     */
    public boolean search(String word) {
        Node currentNode = root;
        char[] arr = word.toCharArray();
        for (char currentChar : arr) {
            if (!currentNode.children.containsKey(currentChar)) {
                return false;
            }
            currentNode = currentNode.children.get(currentChar);
        }
        return currentNode.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with prefix.
     * @param prefix
     * @return true or false.
     */
    public boolean startsWith(String prefix) {
        Node currentNode = root;
        char[] arr = prefix.toCharArray();
        for (char currentChar : arr) {
            if (!currentNode.children.containsKey(currentChar)) {
                return false;
            }
            currentNode = currentNode.children.get(currentChar);
        }
        return true;
    }


    public class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }
}
