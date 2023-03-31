import java.util.ArrayDeque;
import java.util.List;

/**
 * @author 11214
 * @since 2023/3/14 10:55
 */
public class Solution25 {
    public ListNode addNode(ListNode list, int x) {
        ListNode node = new ListNode(x);
        node.next = list;
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<ListNode> q1 = new ArrayDeque<>();
        ArrayDeque<ListNode> q2 = new ArrayDeque<>();
        while (l1 != null) {
            q1.offer(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            q2.offer(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int x = q1.pollLast().val;
            int y = q2.pollLast().val;
            int z = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            head = addNode(head, z);
        }
        while (!q1.isEmpty()) {
            int x = q1.pollLast().val;
            int z = (x + carry) % 10;
            carry = (x + carry) / 10;
            head = addNode(head, z);
        }
        while (!q2.isEmpty()) {
            int x = q2.pollLast().val;
            int z = (x + carry) % 10;
            carry = (x + carry) / 10;
            head = addNode(head, z);
        }
        if (carry != 0) {
            head = addNode(head, carry);
        }
        return head;
    }
}
