/**
 * @author 11214
 * @since 2023/3/11 9:44
 */
public class Solution23 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        while (ptr1.next != null && ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ListNode ptr3;
        ListNode ptr4; // 长的
        ListNode ptr5; // 短的
        if (ptr1.next == null) {
            ptr3 = ptr2;
            ptr4 = headB;
            ptr5 = headA;
        } else {
            ptr3 = ptr1;
            ptr4 = headA;
            ptr5 = headB;
        }

        while (ptr3.next != null) {
            ptr3 = ptr3.next;
            ptr4 = ptr4.next;
        }
        while (ptr4 != null && ptr5 != null) {
            if (ptr4 == ptr5) {
                return ptr4;
            }
            ptr4 = ptr4.next;
            ptr5 = ptr5.next;
        }
        return null;
    }
}
