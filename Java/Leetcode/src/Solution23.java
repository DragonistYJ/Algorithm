import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
NO23 合并K个排序链表
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>(1000000);
        for (ListNode listNode : lists) {
            ListNode node = listNode;
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        if (list.size() == 0) return null;

        ListNode header = new ListNode(list.get(0));
        ListNode tmp = header;
        for (int i = 1; i < list.size(); i++) {
            tmp.next = new ListNode(list.get(i));
            tmp = tmp.next;
        }
        return header;
    }

    public static void main(String[] args) {

    }
}
