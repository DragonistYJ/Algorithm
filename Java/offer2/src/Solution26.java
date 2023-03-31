import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2023/3/31 10:03
 */
public class Solution26 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp);
            ListNode next = tmp.next;
            tmp.next = null;
            tmp = next;
        }
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            ListNode a = list.get(i);
            ListNode b = list.get(n - i - 1);
            ListNode c = list.get(i + 1);
            a.next = b;
            if (b != c) {
                b.next = c;
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        new Solution26().reorderList(node1);
    }
}
