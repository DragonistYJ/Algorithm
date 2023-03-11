/**
 * @author 11214
 * @since 2023/3/11 10:13
 */
public class Solution21 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode ptr = head;
        while (ptr != null) {
            len += 1;
            ptr = ptr.next;
        }

        if (n == len) {
            return head.next;
        }
        ptr = head;
        for (int i = 1; i <= len - n - 1; i++) {
            ptr = ptr.next;
        }
        ptr.next = ptr.next.next;
        return head;
    }
}
