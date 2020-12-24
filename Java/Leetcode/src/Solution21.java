import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
NO21 合并两个有序链表
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = l1;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        tmp = l2;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        list.sort(Comparator.comparingInt(o -> o));
        if (list.size() == 0) return null;
        ListNode header = new ListNode(list.get(0));
        list.remove(0);
        ListNode node = header;
        for (Integer value : list) {
            node.next = new ListNode(value);
            node = node.next;
        }
        return header;
    }

    public static void main(String[] args) {

    }
}
