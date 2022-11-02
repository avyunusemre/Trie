package sozluk;

import java.util.HashMap;
import java.util.Map;

public class Trie2 {

    private Node2 root;

    public Trie2() {
        root = new Node2();
    }

    /**
     * trie'ye bir kelime ekler.
     * @param word
     */
    public void insert(String word) {
        Node2 suankiNode = root;
        char[] arr = word.toCharArray();
        for (char suankiKarakter : arr) {
            if (!suankiNode.children.containsKey(suankiKarakter)) {
                suankiNode.children.put(suankiKarakter, new Node2());
            }
            suankiNode = suankiNode.children.get(suankiKarakter);
        }
        suankiNode.isWord = true;
    }


    public boolean search(String word) {
        Node2 suankiNode = root;
        char[] arr = word.toCharArray();
        for (char suankiKarakter : arr) {
            if (!suankiNode.children.containsKey(suankiKarakter)) {
                return false;
            }
            suankiNode = suankiNode.children.get(suankiKarakter);
        }
        return suankiNode.isWord;
    }

    public boolean startsWith(String prefix) {
        Node2 suankiNode = root;
        char[] arr = prefix.toCharArray();
        for (char suankiKarakter : arr) {
            if (!suankiNode.children.containsKey(suankiKarakter)) {
                return false;
            }
            suankiNode = suankiNode.children.get(suankiKarakter);
        }
        return true;
    }


    public class Node2 {
        Map<Character, Node2> children = new HashMap<>();
        boolean isWord = false;
    }
}
