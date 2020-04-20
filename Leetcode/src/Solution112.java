/*
NO112 路径总和
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
说明: 叶子节点是指没有子节点的节点。
 */
public class Solution112 {
    private boolean flag;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        flag = false;
        dfs(root, 0, sum);
        return flag;
    }

    private void dfs(TreeNode root, int sum, int target) {
        if (flag) return;
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) flag = true;
            return;
        }

        if (root.left != null) dfs(root.left, sum + root.val, target);
        if (root.right != null) dfs(root.right, sum + root.val, target);
    }

    public static void main(String[] args) {

    }
}
