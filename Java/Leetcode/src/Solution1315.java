/*
NO1315 祖父节点值为偶数的节点和
给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：

该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
如果不存在祖父节点值为偶数的节点，那么返回 0 。
 */
public class Solution1315 {
    public int sumEvenGrandparent(TreeNode root) {
        return search(root);
    }

    private int search(TreeNode root) {
        if (root == null) return 0;
        if (root.val % 2 == 1) {
            return search(root.left) + search(root.right);
        } else {
            int sum = 0;
            if (root.left != null) {
                if (root.left.left != null) sum += root.left.left.val;
                if (root.left.right != null) sum += root.left.right.val;
            }
            if (root.right != null) {
                if (root.right.left != null) sum += root.right.left.val;
                if (root.right.right != null) sum += root.right.right.val;
            }
            return sum + search(root.left) + search(root.right);
        }
    }

    public static void main(String[] args) {

    }
}
