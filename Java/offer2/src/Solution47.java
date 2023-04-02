/**
 * @author 11214
 * @since 2023/4/2 9:54
 */
public class Solution47 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null) {
            return root.val == 0 ? null : root;
        } else {
            return root;
        }
    }
}
