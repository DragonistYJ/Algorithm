import java.util.HashSet;

/**
 * @author 11214
 * @since 2023/3/10 10:38
 */
public class Solution17 {
    public int char2int(char c) {
        if (c >= 'a') {
            return c - 'a';
        } else {
            return c - 'A' + 26;
        }
    }

    public boolean check(int[] s, int[] t) {
        for (int i = 0; i < 52; i++) {
            if (s[i] < t[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int n = s.length();
        int[] tBits = new int[52];
        HashSet<Character> targets = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            int x = char2int(t.charAt(i));
            tBits[x] += 1;
            targets.add(t.charAt(i));
        }
        int i = 0;
        int j = 0;
        while (j < n && !targets.contains(s.charAt(j))) {
            i += 1;
            j += 1;
        }
        if (n - i < t.length()) {
            return "";
        }

        boolean flag = false;
        int[] sBits = new int[52];
        String ans = s;
        while (true) {
            if (check(sBits, tBits)) {
                if (ans.length() >= j - i) {
                    flag = true;
                    ans = s.substring(i, j);
                }
                int x = char2int(s.charAt(i));
                sBits[x] -= 1;
                i += 1;
                while (i < s.length() && !targets.contains(s.charAt(i))) {
                    x = char2int(s.charAt(i));
                    sBits[x] -= 1;
                    i += 1;
                }
            } else {
                if (j == n) {
                    break;
                }
                int x = char2int(s.charAt(j));
                sBits[x] += 1;
                j += 1;
            }
        }

        return flag ? ans : "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution17().minWindow("a", "a"));
    }
}
