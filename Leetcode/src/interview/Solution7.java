package interview;

import util.TreeNode;

/**
 * @ClassName Solution7
 * @Author 11214
 * @Date 2020/4/11
 * @Description TODO
 */
public class Solution7 {
    public TreeNode build(int[] preorder, int preL, int[] inorder, int inL, int inR) {
        if (preL >= preorder.length || inL > inR) return null;

        TreeNode treeNode = new TreeNode(preorder[preL]);
        if (inL == inR) {
            treeNode.left = null;
            treeNode.right = null;
        } else {
            int pos = inL;
            while (inorder[pos] != preorder[preL]) pos += 1;
            treeNode.left = build(preorder, preL + 1, inorder, inL, pos - 1);
            treeNode.right = build(preorder, preL + 1 + pos - inL, inorder, pos + 1, inR);
        }
        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};
        new Solution7().buildTree(preorder, inorder);
    }
}
