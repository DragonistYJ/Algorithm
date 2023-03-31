/**
 * @author 11214
 * @since 2023/3/13 10:08
 */
public class Solution24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode third = next.next;
            next.next = curr;
            curr = next;
            next = third;
        }
        head.next = null;
        return curr;
    }
}
