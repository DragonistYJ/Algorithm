package interview;

import util.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Solution6
 * @Author 11214
 * @Date 2020/4/11
 * @Description TODO
 */
public class Solution6 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        int len = stack.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
