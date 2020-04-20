package interview;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * @ClassName Solution48
 * @Author 11214
 * @Date 2020/4/13
 * @Description TODO
 */
public class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        HashSet<Character> hashSet = new HashSet<>();
        int ans = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (hashSet.contains(c)) {
                while (!deque.isEmpty() && deque.peekFirst() != c) {
                    hashSet.remove(deque.pollFirst());
                }
                deque.pollFirst();
                deque.offerLast(c);
                ans = Math.max(ans, deque.size());
            } else {
                deque.offerLast(c);
                hashSet.add(c);
                ans = Math.max(ans, deque.size());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution48().lengthOfLongestSubstring("bbbbbbb"));
    }
}
