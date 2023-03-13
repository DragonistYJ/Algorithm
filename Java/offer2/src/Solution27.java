import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2023/3/13 10:57
 */
public class Solution27 {
    public boolean isPalindrome(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        for (int i = 0; i < nodes.size() / 2; i++) {
            if (nodes.get(i).val != nodes.get(nodes.size() - i - 1).val) {
                return false;
            }
        }
        return true;
    }
}
