/*
NO19 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            len += 1;
            tmp = tmp.next;
        }
        if (len == n) return head.next;
        tmp = head;
        for (int i = 0; i < len - n - 1; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
