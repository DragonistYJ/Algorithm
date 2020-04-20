/*
NO110 平衡二叉树
给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class Solution110 {
    private boolean ans;

    public boolean isBalanced(TreeNode root) {
        ans = true;
        deep(root);
        return ans;
    }

    private int deep(TreeNode root) {
        if (root == null) return 0;
        if (!ans) return 0;

        int leftDeep = deep(root.left);
        int rightDeep = deep(root.right);
        if (Math.abs(leftDeep - rightDeep) > 1) ans = false;
        return Math.max(leftDeep, rightDeep) + 1;
    }

    public static void main(String[] args) {

    }
}
