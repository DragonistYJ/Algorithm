import java.util.Arrays;

/**
 * @author yujian
 * @since 2022/9/12 10:20
 * 给定两个整数数组inorder和postorder ，其中inorder是二叉树的中序遍历， postorder是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                k = i;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        root.left = buildTree(
                Arrays.copyOfRange(inorder, 0, k),
                Arrays.copyOfRange(postorder, 0, k));
        root.right = buildTree(
                Arrays.copyOfRange(inorder, k + 1, inorder.length),
                Arrays.copyOfRange(postorder, k, inorder.length - 1));
        return root;
    }
}
