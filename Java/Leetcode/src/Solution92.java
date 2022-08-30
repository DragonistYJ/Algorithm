/**
 * @author 11214
 * @since 2022/8/29 9:54
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回反转后的链表 。
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = head;
        ListNode a = head;
        for (int i = 0; i < left - 1; i++) {
            start = a;
            a = a.next;
        }
        ListNode first = a;
        ListNode b = a.next;
        for (int i = left; i < right; i++) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        first.next = b;

        if (left == 1) {
            return a;
        } else {
            start.next = a;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        Solution92 solution92 = new Solution92();
        System.out.println(solution92.reverseBetween(node1, 5, 5));
    }
}
