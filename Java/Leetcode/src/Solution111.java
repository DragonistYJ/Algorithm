import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.List;

/*
NO111 二叉树的最小深度
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明: 叶子节点是指没有子节点的节点。
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        List<SimpleEntry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new SimpleEntry<>(root, 1));
        while (!queue.isEmpty()) {
            SimpleEntry<TreeNode, Integer> pair = queue.get(0);
            queue.remove(0);
            TreeNode treeNode = pair.getKey();
            Integer deep = pair.getValue();
            if (treeNode.left == null && treeNode.right == null) {
                return deep;
            } else if (treeNode.right == null) {
                queue.add(new SimpleEntry<>(treeNode.left, deep + 1));
            } else if (treeNode.left == null) {
                queue.add(new SimpleEntry<>(treeNode.right, deep + 1));
            } else {
                queue.add(new SimpleEntry<>(treeNode.left, deep + 1));
                queue.add(new SimpleEntry<>(treeNode.right, deep + 1));
            }
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
