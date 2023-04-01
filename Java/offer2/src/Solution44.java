import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2023/4/1 14:31
 */
public class Solution44 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        ArrayDeque<Integer> layers = new ArrayDeque<>();
        nodes.add(root);
        layers.add(0);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pollFirst();
            Integer l = layers.pollFirst();
            if (l >= ans.size()) {
                ans.add(node.val);
            } else {
                ans.set(l, Math.max(node.val, ans.get(l)));
            }

            if (node.left != null) {
                nodes.offerLast(node.left);
                layers.offerLast(l + 1);
            }
            if (node.right != null) {
                nodes.offerLast(node.right);
                layers.offerLast(l + 1);
            }
        }
        return ans;
    }
}
