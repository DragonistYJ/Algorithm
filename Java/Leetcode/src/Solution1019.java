import java.util.ArrayDeque;

/**
 * @author yujian
 * @since 2023/7/22 15:37
 * 给定一个长度为 n 的链表 head
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 */
public class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        ListNode ptr = head;
        while (ptr != null) {
            n += 1;
            ptr = ptr.next;
        }

        int[] res = new int[n];
        ptr = head;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++, ptr = ptr.next) {
            while (!deque.isEmpty() && ptr.val > deque.peekLast()[1]) {
                int[] last = deque.pollLast();
                res[last[0]] = ptr.val;
            }
            deque.offer(new int[]{i, ptr.val});
        }
        return res;
    }
}
