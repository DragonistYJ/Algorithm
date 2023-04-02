/**
 * @author 11214
 * @since 2023/4/2 12:17
 */
public class Solution51 {
    private int ans = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int res = root.val + Math.max(left, right);
        ans = Math.max(ans, root.val);
        ans = Math.max(ans, res);
        ans = Math.max(ans, root.val + left + right);
        return Math.max(res, root.val);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
}
