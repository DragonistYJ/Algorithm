/*
NO91 解码方法
一条包含字母 A-Z 的消息通过以下方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。
 */
public class Solution91 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];

        if (n == 0) return 0;
        ans[0] = 1;
        if (s.charAt(0) > '0' && s.charAt(0) <= '9') {
            ans[1] = 1;
        }
        if (n == 1) return ans[1];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    ans[i + 1] = ans[i + 1 - 2];
                }
            } else {
                if ((s.charAt(i - 1) == '1') || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                    ans[i + 1] = ans[i + 1 - 1] + ans[i + 1 - 2];
                } else {
                    ans[i + 1] = ans[i + 1 - 1];
                }
            }
        }

        return ans[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution91().numDecodings("2222"));
    }
}
