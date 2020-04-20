import java.util.ArrayList;
import java.util.List;

/*
NO25 K个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例 :
给定这个链表：1->2->3->4->5
当 k = 2 时，应当返回: 2->1->4->3->5
当 k = 3 时，应当返回: 3->2->1->4->5

说明 :
你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int index = 0;
        while (index < list.size()) {
            int i = index;
            int j = index + k - 1;
            if (j >= list.size()) break;
            while (i < j) {
                int tmp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, tmp);
                i += 1;
                j -= 1;
            }
            index += k;
        }
        ListNode first = new ListNode(list.get(0));
        ListNode tmp = first;
        for (int i = 1; i < list.size(); i++) {
            tmp.next = new ListNode(list.get(i));
            tmp = tmp.next;
        }
        return first;
    }

    public static void main(String[] args) {

    }
}
