import java.util.ArrayList;
import java.util.List;

/*
NO113 路径总和2
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) return ans;
        dfs(root, 0, path, ans, sum);
        return ans;
    }

    private void dfs(TreeNode root, int tmp, List<Integer> path, List<List<Integer>> ans, int sum) {
        if (root.left == null && root.right == null) {
            if (tmp + root.val == sum) {
                List<Integer> list = new ArrayList<>(path);
                list.add(root.val);
                ans.add(list);
            }
            return;
        }
        if (root.left != null) {
            path.add(root.val);
            dfs(root.left, tmp + root.val, path, ans, sum);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.val);
            dfs(root.right, tmp + root.val, path, ans, sum);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(11);
        node2.left = node4;
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        node3.left = node5;
        node3.right = node6;
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        node4.left = node7;
        node4.right = node8;
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node6.left = node9;
        node6.right = node10;
        System.out.println(new Solution113().pathSum(node1, 22));
    }
}