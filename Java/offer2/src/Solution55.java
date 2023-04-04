import java.util.ArrayDeque;

/**
 * @author 11214
 * @since 2023/4/2 15:59
 */
public class Solution55 {
    static class BSTIterator {
        private final ArrayDeque<TreeNode> deque;

        public BSTIterator(TreeNode root) {
            this.deque = new ArrayDeque<>();
            while (root != null) {
                this.deque.offerLast(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = this.deque.pollLast();
            TreeNode right = node.right;
            while (right != null) {
                this.deque.offerLast(right);
                right = right.left;
            }
            return node.val;
        }

        public boolean hasNext() {
            return !this.deque.isEmpty();
        }
    }
}
