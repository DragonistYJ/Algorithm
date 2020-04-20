/**
 * @ClassName Solution530
 * @Author 11214
 * @Date 2020/4/20
 * @Description TODO
 */
public class Solution530 {
    private int pre;
    private int ans;

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != Integer.MAX_VALUE) {
            ans = Math.min(ans, Math.abs(pre - root.val));
        }
        pre = root.val;
        dfs(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        pre = Integer.MAX_VALUE;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }
}
