/*
NO44 通配符匹配
给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。
说明:
s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 */
public class Solution44 {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int istar = -1;
        int jstar = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i += 1;
                j += 1;
            } else if (j < p.length() && p.charAt(j) == '*') {
                istar = i;
                jstar = j++;
            } else if (istar != -1) {
                i = ++istar;
                j = jstar + 1;
            } else return false;
        }
        while (j < p.length() && p.charAt(j) == '*') j++;
        return j == p.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution44().isMatch("aaaa", "***a"));
    }
}
