/**
 * @author yujian
 * @since 2023/7/20 11:01
 * <p>
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 */
public class Solution208 {
    static class Node {
        boolean isLeaf = false;
        Node[] kids = new Node[26];
    }

    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int k = word.charAt(i) - 'a';
                if (curr.kids[k] == null) {
                    curr.kids[k] = new Node();
                }
                curr = curr.kids[k];
            }
            curr.isLeaf = true;
        }

        public boolean search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int k = word.charAt(i) - 'a';
                if (curr.kids[k] == null) {
                    return false;
                }
                curr = curr.kids[k];
            }
            return curr.isLeaf;
        }

        public boolean startsWith(String prefix) {
            Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                int k = prefix.charAt(i) - 'a';
                if (curr.kids[k] == null) {
                    return false;
                }
                curr = curr.kids[k];
            }
            return true;
        }
    }
}
