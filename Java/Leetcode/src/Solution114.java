/**
 * @author yujian
 * @since 2022/9/10 14:45
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Solution114 {
    private TreeNode flat(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = null;
        if (root.left != null) {
            left = flat(root.left);
        }
        TreeNode right = null;
        if (root.right != null) {
            right = flat(root.right);
        }
        root.left = null;
        root.right = null;
        if (left != null) {
            root.right = left;
        }
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;
        return root;
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flat(root);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        new Solution114().flatten(node1);
        System.out.println(node1);
    }
}
