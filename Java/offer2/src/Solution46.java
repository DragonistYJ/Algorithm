import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2023/4/1 14:44
 */
public class Solution46 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        ArrayDeque<Integer> layers = new ArrayDeque<>();
        nodes.offerLast(root);
        layers.offerLast(0);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pollFirst();
            Integer layer = layers.pollFirst();
            if (layer >= ans.size()) {
                ans.add(node.val);
            }
            if (node.right != null) {
                nodes.offerLast(node.right);
                layers.offerLast(layer + 1);
            }
            if (node.left != null) {
                nodes.offerLast(node.left);
                layers.offerLast(layer + 1);
            }
        }

        return ans;
    }
}
