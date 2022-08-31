/**
 * @author 11214
 * @since 2022/8/31 10:04
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }

        ListNode a = head;
        ListNode b = head.next;
        while (b != null) {
            if (b.val == val) {
                a.next = b.next;
                b = a.next;
            } else {
                a = b;
                b = b.next;
            }
        }

        return head;
    }
}
