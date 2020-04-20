/*
NO104 二叉树的最大深度
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
 */
public class Solution104 {
    int ans = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return ans;
    }

    public void dfs(TreeNode root, int deep) {
        ans = Math.max(deep, ans);
        if (root.left != null) dfs(root.left, deep + 1);
        if (root.right != null) dfs(root.right, deep + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        System.out.println(new Solution104().maxDepth(treeNode0));
    }
}
