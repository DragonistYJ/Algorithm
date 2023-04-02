/**
 * @author 11214
 * @since 2023/4/2 11:56
 */
public class Solution50 {
    private int ans;
    private long target;

    private void deepDfs(TreeNode root, long sum) {
        if (sum == target) {
            ans += 1;
        }
        if (root.left != null) {
            deepDfs(root.left, sum + root.left.val);
        }
        if (root.right != null) {
            deepDfs(root.right, sum + root.right.val);
        }
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            deepDfs(root, root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        dfs(root);
        return ans;
    }
}
