import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName 词典中最长的单词
 * @Author 11214
 * @Date 2020/4/15
 * @Description 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * 若无答案，则返回空字符串。
 */
public class Solution720 {
    private class TreeNode {
        private Character c;
        private List<TreeNode> next;

        public TreeNode(Character c, List<TreeNode> next) {
            this.c = c;
            this.next = next;
        }
    }

    private void construct(TreeNode treeNode, String word) {
        if (word.length() == 0) return;
        char c = word.charAt(0);
        for (TreeNode node : treeNode.next) {
            if (node.c == c) {
                construct(node, word.substring(1));
                return;
            }
        }
        TreeNode node = new TreeNode(c, new ArrayList<>());
        treeNode.next.add(node);
        construct(node, word.substring(1));
    }

    private String ans;

    private void dfs(StringBuilder builder, TreeNode treeNode, HashSet<String> hashSet) {
        String s = builder.toString();
        if (hashSet.contains(s)) {
            if (s.length() > ans.length()) ans = s;
            else if (s.length() == ans.length() && s.compareTo(ans) < 0) ans = s;
        } else if (!s.equals("")) {
            return;
        }

        for (TreeNode node : treeNode.next) {
            builder.append(node.c);
            dfs(builder, node, hashSet);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public String longestWord(String[] words) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(words));
        TreeNode root = new TreeNode(null, new ArrayList<>());
        for (String s : words) {
            construct(root, s);
        }
        ans = "";
        dfs(new StringBuilder(), root, hashSet);
        if (ans.length() == 1) return ans;
        else return ans;
    }

    public static void main(String[] args) {
        String[] word = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(new Solution720().longestWord(word));
    }
}
