import java.util.ArrayList;
import java.util.List;

/*
NO94 二叉树的中序遍历
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        inorder(root, ans);
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        if (root.left != null) {
            inorder(root.left, ans);
        }
        ans.add(root.val);
        if (root.right != null) {
            inorder(root.right, ans);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        treeNode0.right = treeNode1;
        TreeNode treeNode2 = new TreeNode(3);
        treeNode1.left = treeNode2;
        System.out.println(new Solution94().inorderTraversal(treeNode0));
    }
}


