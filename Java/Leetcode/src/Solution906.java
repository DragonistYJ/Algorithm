import java.util.ArrayList;
import java.util.List;

/*
NO906 超级回文数
如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
 */
public class Solution906 {
    public int superpalindromesInRange(String L, String R) {
        long left = Long.parseLong(L);
        long right = Long.parseLong(R);
        int ans = 0;
        for (int bits = 1; bits <= 9; bits++) {
            int start = (int) Math.pow(10, (bits - 1) / 2);
            int end = (int) Math.pow(10, (bits - 1) / 2 + 1);
            boolean flag = false;
            for (int i = start; i < end; i++) {
                long palindrome;
                if (bits % 2 == 1) {
                    palindrome = makeSingle(i);
                } else {
                    palindrome = makeDouble(i);
                }
                palindrome = palindrome * palindrome;
                if (palindrome >= left && palindrome <= right && isPalindrome(palindrome)) {
                    ans += 1;
                }
                if (palindrome > right) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        return ans;
    }

    private long makeDouble(int x) {
        StringBuilder builder = new StringBuilder(String.valueOf(x));
        String s = builder.reverse().toString();
        builder.reverse().append(s);
        return Long.parseLong(builder.toString());
    }

    private long makeSingle(int x) {
        StringBuilder builder = new StringBuilder(String.valueOf(x));
        int length = builder.length();
        String s = builder.reverse().toString();
        builder.reverse().append(s);
        builder.deleteCharAt(length);
        return Long.parseLong(builder.toString());
    }

    private boolean isPalindrome(long x) {
        StringBuilder builder = new StringBuilder(String.valueOf(x));
        return builder.toString().equals(builder.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution906().superpalindromesInRange("1", "19028"));
    }
}
