/*
NO687 最长同值路径
给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
注意：两个节点之间的路径长度由它们之间的边数表示。
 */
public class Solution687 {
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        ans = 0;
        int dfs = dfs(root);
        return Math.max(ans, dfs);
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        if (root.right == null) {
            int tmp = dfs(root.left);
            ans = Math.max(ans, tmp);
            if (root.val == root.left.val) {
                return tmp + 1;
            } else {
                return 0;
            }
        } else if (root.left == null) {
            int tmp = dfs(root.right);
            ans = Math.max(ans, tmp);
            if (root.val == root.right.val) {
                return tmp + 1;
            } else {
                return 0;
            }
        } else {
            int tmpLeft = dfs(root.left);
            int tmpRight = dfs(root.right);
            ans = Math.max(ans, Math.max(tmpLeft, tmpRight));
            if (root.val == root.left.val && root.val == root.right.val) {
                ans = Math.max(ans, tmpLeft + tmpRight + 2);
                return Math.max(tmpLeft, tmpRight) + 1;
            } else if (root.val == root.left.val) {
                return tmpLeft + 1;
            } else if (root.val == root.right.val) {
                return tmpRight + 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        node1.left = node2;
        node2.left = new TreeNode(4);
        node2.right = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        node1.right = node3;
        node3.right = new TreeNode(6);
        System.out.println(new Solution687().longestUnivaluePath(node1));
    }
}
