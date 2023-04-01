/**
 * @author 11214
 * @since 2023/4/1 14:38
 */
public class Solution45 {
    private int layer = -1;
    private int val = 0;

    public void dfs(TreeNode root, int layer) {
        if (root == null) {
            return;
        }
        dfs(root.left, layer + 1);
        if (layer > this.layer) {
            this.layer = layer;
            val = root.val;
        }
        dfs(root.right, layer + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return val;
    }
}
