import java.util.HashSet;

/*
NO160 相交链表
编写一个程序，找到两个单链表相交的起始节点。
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode tmp = headA;
        while (tmp != null) {
            hashSet.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            if (hashSet.contains(tmp)) return tmp;
            tmp = tmp.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
