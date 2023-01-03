/**
 * @author 11214
 * @since 2023/1/3 14:42
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (slow == null) {
                return null;
            }
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
        }
        ListNode ptr = head;
        while (ptr != slow) {
            ptr = ptr.next;
            slow = slow.next;
        }
        return ptr;
    }
}
