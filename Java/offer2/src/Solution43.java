import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2023/4/1 14:20
 */
public class Solution43 {
    class CBTInserter {
        private List<TreeNode> nodes;

        public CBTInserter(TreeNode root) {
            nodes = new ArrayList<>();
            nodes.add(root);
            int i = 0;
            while (i < nodes.size()) {
                TreeNode node = nodes.get(i);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
                node.left = null;
                node.right = null;
                i += 1;
            }

            for (i = 0; i < nodes.size() / 2; i++) {
                TreeNode parent = nodes.get(i);
                if (i * 2 + 1 < nodes.size()) {
                    parent.left = nodes.get(i * 2 + 1);
                }
                if (i * 2 + 2 < nodes.size()) {
                    parent.right = nodes.get(i * 2 + 2);
                }
            }
        }

        public int insert(int v) {
            TreeNode node = new TreeNode(v);
            nodes.add(node);
            TreeNode parent = nodes.get((nodes.size() - 2) / 2);
            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            return parent.val;
        }

        public TreeNode get_root() {
            return nodes.get(0);
        }
    }
}
