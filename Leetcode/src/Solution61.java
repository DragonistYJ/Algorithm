import java.util.ArrayList;
import java.util.List;

/*
NO61 旋转链表
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode tmp = head;
        List<Integer> list = new ArrayList<>();
        while (tmp != null) {
            len += 1;
            list.add(tmp.val);
            tmp = tmp.next;
        }
        tmp = head;
        k = k % len;
        for (int i = 0; i < len; i++) {
            tmp.val = list.get((i - k + len) % len);
            tmp = tmp.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
