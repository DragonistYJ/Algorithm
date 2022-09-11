import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yujian
 * @since 2022/9/11 15:06
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        Queue<ListNode> forward = new ArrayDeque<>();
        Stack<ListNode> backward = new Stack<>();
        int i = 0;
        ListNode temp = head;
        while (temp != null) {
            forward.offer(temp);
            backward.push(temp);
            i += 1;
            temp = temp.next;
        }
        temp = forward.poll();
        for (int j = 1; j < i; j++) {
            if (j % 2 == 0) {
                temp.next = forward.poll();
            } else {
                temp.next = backward.pop();
            }
            temp = temp.next;
        }
        temp.next = null;
    }

    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        solution143.reorderList(node1);
    }
}
