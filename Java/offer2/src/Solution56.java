import java.util.ArrayDeque;

/**
 * @author 11214
 * @since 2023/4/4 10:17
 */
public class Solution56 {
    public boolean findTarget(TreeNode root, int k) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            if (node.left != null) {
                deque.offerLast(node.left);
            }
            if (node.right != null) {
                deque.offerLast(node.right);
            }

            int t = k - node.val;
            TreeNode ptr = root;
            while (ptr != null) {
                if (ptr.val == t) {
                    if (node == ptr) {
                        break;
                    } else {
                        return true;
                    }
                } else if (ptr.val < t) {
                    ptr = ptr.right;
                } else {
                    ptr = ptr.left;
                }
            }
        }
        return false;
    }
}
