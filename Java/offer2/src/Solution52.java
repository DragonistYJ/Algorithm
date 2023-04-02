/**
 * @author 11214
 * @since 2023/4/2 11:47
 */
public class Solution52 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = increasingBST(root.left);
        if (left != null) {
            TreeNode tmp = left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            tmp.right = root;
        } else {
            left = root;
        }

        root.right = increasingBST(root.right);
        root.left = null;
        return left;
    }
}
