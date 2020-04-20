/*
NO24 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode ret;
        if (head == null) return null;
        if (head.next == null) ret = head;
        else ret = head.next;

        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            if (next == null) break;
            ListNode tmp = next.next;
            if (next.next == null) {
                next.next = curr;
                curr.next = null;
            } else if (next.next.next == null) {
                curr.next = next.next;
                next.next = curr;
            } else {
                curr.next = next.next.next;
                next.next = curr;
            }
            curr = tmp;
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        //ListNode listNode3 = new ListNode(3);
        //ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        //listNode2.next = listNode3;
        //listNode3.next = listNode4;
        ListNode listNode = new Solution24().swapPairs(listNode1);
        while (listNode !=null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
