import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution144
 * @Author 11214
 * @Date 2020/6/1
 * @Description TODO
 */
public class Solution144 {
    private void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }
}
