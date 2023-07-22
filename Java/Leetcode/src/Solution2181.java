/**
 * @author yujian
 * @since 2023/7/22 15:32
 */
public class Solution2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode ptr = head.next;
        ListNode h = new ListNode(0);
        ListNode c = h;
        int sum = 0;
        while (ptr != null) {
            sum += ptr.val;
            if (ptr.val == 0) {
                c.next = new ListNode(sum);
                c = c.next;
                sum = 0;
            }
            ptr = ptr.next;
        }
        return h.next;
    }
}
