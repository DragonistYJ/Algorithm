/**
 * @author 11214
 * @since 2023/3/13 10:41
 */

public class Solution29 {
    private static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);
        if (head == null) {
            insert.next = insert;
            return insert;
        }
        if (head == head.next) {
            head.next = insert;
            insert.next = head;
            return head;
        }

        Node curr = head;
        Node max = head;
        int round = 0;
        while (true) {
            if (curr == head) {
                round += 1;
            }
            if (curr.val <= insertVal && curr.next.val >= insertVal) {
                insert.next = curr.next;
                curr.next = insert;
                break;
            }
            if (curr.val >= max.val) {
                max = curr;
            }
            if (round == 2) {
                insert.next = max.next;
                max.next = insert;
                break;
            }
            curr = curr.next;
        }

        return head;
    }
}
