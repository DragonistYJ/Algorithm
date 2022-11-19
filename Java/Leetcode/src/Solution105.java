import java.util.Arrays;

/**
 * @author yujian
 * @since 2022/9/12 10:13
 * 给定两个整数数组preorder和inorder，其中preorder是二叉树的先序遍历，inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                k = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + k), Arrays.copyOfRange(inorder, 0, k));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + k, preorder.length), Arrays.copyOfRange(inorder, k + 1, inorder.length));
        return root;
    }
}
