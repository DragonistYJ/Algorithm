/**
 * @ClassName Solution783
 * @Author 11214
 * @Date 2020/4/20
 * @Description TODO
 */
public class Solution783 {
    private int pre;
    private int ans;

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != Integer.MAX_VALUE) {
            ans = Math.min(ans, Math.abs(pre - root.val));
        }
        pre = root.val;
        dfs(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        pre = Integer.MAX_VALUE;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(71);
        TreeNode node2 = new TreeNode(62);
        TreeNode node3 = new TreeNode(84);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(14);
        node2.left = node4;
        TreeNode node5 = new TreeNode(88);
        node3.right = node5;
        System.out.println(new Solution783().minDiffInBST(node1));
    }
}
