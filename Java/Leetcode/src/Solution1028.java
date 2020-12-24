import java.util.ArrayList;
import java.util.List;

/*
NO1028 从先序遍历还原二叉树
我们从二叉树的根节点 root 开始进行深度优先搜索。
在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
如果节点只有一个子节点，那么保证该子节点为左子节点。
给出遍历输出 S，还原树并返回其根节点 root。
 */
public class Solution1028 {
    private class Pair {
        private int level;
        private int value;

        public Pair(int level, int value) {
            this.level = level;
            this.value = value;
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        List<Pair> nodes = new ArrayList<>();
        int index = 0;
        while (index < S.length()) {
            int l = index;
            while (S.charAt(l) == '-') l += 1;
            int n = l;
            while (n < S.length() && Character.isDigit(S.charAt(n))) n += 1;
            nodes.add(new Pair(l - index, Integer.parseInt(S.substring(l, n))));
            index = n;
        }

        return construct(nodes, 0);
    }

    private TreeNode construct(List<Pair> nodes, int level) {
        if (nodes.isEmpty() || nodes.get(0).level != level) {
            return null;
        }

        Pair pair = nodes.get(0);
        nodes.remove(0);
        TreeNode root = new TreeNode(pair.value);
        root.left = construct(nodes, level + 1);
        root.right = construct(nodes, level + 1);
        return root;
    }

    public static void main(String[] args) {
        new Solution1028().recoverFromPreorder("1-2--3---4-5--6---7");
    }
}
