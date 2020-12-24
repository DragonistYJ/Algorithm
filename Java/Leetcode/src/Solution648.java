import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName 单词替换
 * @Author 11214
 * @Date 2020/4/15
 * @Description 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 你需要输出替换之后的句子。
 */
public class Solution648 {
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

    public String replaceWords(List<String> dict, String sentence) {
        int maxRoot = 0;
        HashSet<String> hashSet = new HashSet<>();
        for (String s : dict) {
            hashSet.add(s);
            maxRoot = Math.max(maxRoot, s.length());
        }
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            int len = Math.min(strings[i].length(), maxRoot);
            for (int j = 1; j <= len; j++) {
                if (hashSet.contains(strings[i].substring(0, j))) {
                    strings[i] = strings[i].substring(0, j);
                    break;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
        System.out.println(new Solution648().replaceWords(list, "the cattle was rattled by the battery"));
    }
}
