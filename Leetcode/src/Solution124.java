/*
NO124 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。
本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class Solution124 {
    private int ans;

    public int maxPathSum(TreeNode root) {
        ans = root.val;
        int dfs = dfs(root);
        return Math.max(dfs, ans);
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        if (root.right == null) {
            int tmp = dfs(root.left);
            ans = Math.max(ans, tmp);
            return Math.max(root.val, root.val + tmp);
        } else if (root.left == null) {
            int tmp = dfs(root.right);
            ans = Math.max(ans, tmp);
            return Math.max(root.val, root.val + tmp);
        } else {
            int tmpLeft = dfs(root.left);
            ans = Math.max(ans, tmpLeft);
            int tmpRight = dfs(root.right);
            ans = Math.max(ans, tmpRight);
            ans = Math.max(ans, root.val + tmpLeft + tmpRight);
            return Math.max(root.val, Math.max(root.val + tmpLeft, root.val + tmpRight));
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-1);
        node1.left = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        node1.right = node2;
        node2.left = new TreeNode(15);
        node2.right = new TreeNode(7);
        System.out.println(new Solution124().maxPathSum(node1));
    }
}
