/**
 * @author 11214
 * @since 2022/12/27 10:54
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Solution98 {
    private boolean check(TreeNode root, long upper, long lower) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return root.val > lower && root.val < upper;
        }
        boolean self = root.val > lower && root.val < upper;
        boolean left = check(root.left, root.val, lower);
        boolean right = check(root.right, upper, root.val);
        return self && left && right;
    }

    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
}
