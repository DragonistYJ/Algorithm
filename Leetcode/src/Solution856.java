import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName Solution856
 * @Author 11214
 * @Date 2020/6/2
 * @Description TODO
 */
public class Solution856 {
    public int cal(HashMap<Integer, Integer> hashMap, int left, int right) {
        if (left == right - 1) return 1;
        int sum = 0;
        for (int i = left + 1; i < right; i++) {
            if (hashMap.containsKey(i)) {
                sum += cal(hashMap, i, hashMap.get(i));
                hashMap.remove(i);
            }
        }
        return 2 * sum;
    }

    public int scoreOfParentheses(String S) {
        S = "(" + S + ")";
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stackIndex = new Stack<>();
        int n = S.length();
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '(') {
                stackIndex.push(i);
            } else {
                hashMap.put(stackIndex.pop(), i);
            }
        }
        return cal(hashMap, 0, n - 1) / 2;
    }

    public static void main(String[] args) {
        String s = "()()()";
        System.out.println(new Solution856().scoreOfParentheses(s));
    }
}
