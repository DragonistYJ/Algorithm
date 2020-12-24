import java.util.ArrayList;
import java.util.List;

/*
NO86 分隔链表
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode tmp = head;
        List<Integer> list = new ArrayList<>();
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        ListNode ans = new ListNode(0);
        tmp = ans;
        int index = 0;
        while (index < list.size()) {
            if (list.get(index) < x) {
                tmp.next = new ListNode(list.get(index));
                tmp = tmp.next;
                list.remove(index);
            } else {
                index += 1;
            }
        }
        for (Integer integer : list) {
            tmp.next = new ListNode(integer);
            tmp = tmp.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {

    }
}
