/**
 * 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class Solution567 {
    private boolean equals(int[] f1, int[] f2) {
        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int n = s1.length();
        int[] feature1 = new int[26];
        for (int i = 0; i < n; i++) {
            feature1[s1.charAt(i) - 'a'] += 1;
        }
        int[] feature2 = new int[26];
        for (int i = 0; i < n; i++) {
            feature2[s2.charAt(i) - 'a'] += 1;
        }

        if (equals(feature1, feature2)) return true;
        for (int i = n; i < s2.length(); i++) {
            feature2[s2.charAt(i - n) - 'a'] -= 1;
            feature2[s2.charAt(i) - 'a'] += 1;
            if (equals(feature1, feature2)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(new Solution567().checkInclusion(s1, s2));
    }
}
