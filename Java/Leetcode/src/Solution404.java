/**
 * @author yujian
 * @since 2022/11/27 11:01
 * <p>
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.left != null && root.left.left == null && root.left.right == null ? root.left.val : 0;
        return val + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
