/*
NO83 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode newHeader = new ListNode(head.val);
        ListNode tmp = newHeader;
        head = head.next;
        while (head != null) {
            if (head.val != tmp.val) {
                tmp.next = new ListNode(head.val);
                tmp = tmp.next;
            }
            head = head.next;
        }
        return newHeader;
    }

    public static void main(String[] args) {

    }
}
