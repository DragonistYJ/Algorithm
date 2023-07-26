/**
 * @author yujian
 * @since 2023/7/26 15:46
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class Solution116 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.right != null) {
            connect(root.left, root.right);
        }
        return root;
    }

    private void connect(Node left, Node right) {
        left.next = right;
        if (left.left != null) {
            connect(left.left, left.right);
        }
        if (left.right != null) {
            connect(left.right, right.left);
        }
        if (right.left != null) {
            connect(right.left, right.right);
        }
    }
}
