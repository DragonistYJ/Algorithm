import java.util.ArrayList;
import java.util.List;

/*
NO145 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(ans, root);
        return ans;
    }

    private void postOrder(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        postOrder(ans, root.left);
        postOrder(ans, root.right);
        ans.add(root.val);
    }
}
