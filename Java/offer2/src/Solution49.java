/**
 * @author 11214
 * @since 2023/4/2 10:01
 */
public class Solution49 {
    private int sum;

    public void dfs(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += num * 10 + root.val;
            return;
        }
        dfs(root.left, num * 10 + root.val);
        dfs(root.right, num * 10 + root.val);
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
}
