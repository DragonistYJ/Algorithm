import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
NO82 删除排序链表中的重复元素2
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        ListNode tmp = head;
        while (tmp != null) {
            if (!hashSet.contains(tmp.val)) {
                hashSet.add(tmp.val);
                list.add(tmp.val);
            } else {
                if (!list.isEmpty() && list.get(list.size() - 1) == tmp.val) {
                    list.remove(list.size() - 1);
                }
            }
            tmp = tmp.next;
        }
        ListNode ans = new ListNode(0);
        tmp = ans;
        for (Integer integer : list) {
            tmp.next = new ListNode(integer);
            tmp = tmp.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {

    }
}
