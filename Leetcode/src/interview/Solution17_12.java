package interview;

import util.TreeNode;

/**
 * @ClassName Solution17_12
 * @Author 11214
 * @Date 2020/4/21
 * @Description TODO
 */
public class Solution17_12 {
    private TreeNode ans, curr;

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        root.left = null;
        curr.right = root;
        curr = root;
        inOrder(root.right);
    }

    public TreeNode convertBiNode(TreeNode root) {
        ans = new TreeNode(0);
        curr = ans;
        inOrder(root);
        return ans.right;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(6);
        node3.right = node6;
        TreeNode node7 = new TreeNode(0);
        node4.left = node7;
        new Solution17_12().convertBiNode(node1);
        System.out.println(1);
    }
}
