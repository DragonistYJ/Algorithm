/**
 * @author 11214
 * @since 2023/3/13 10:27
 */
public class Solution28 {
    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node children = flatten(curr.child);
                Node next = curr.next;
                curr.next = children;
                children.prev = curr;
                while (children.next != null) {
                    children = children.next;
                }
                children.next = next;
                if (next != null) {
                    next.prev = children;
                }
                curr.child = null;
                curr = children;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.child = node2;
        node2.child = node3;
        Node flatten = new Solution28().flatten(node1);
        System.out.println(flatten);
    }
}
