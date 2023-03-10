/**
 * @author 11214
 * @since 2023/3/10 10:07
 */
public class Solution19 {
    private int check(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return i;
            }
            i += 1;
            j -= 1;
        }
        return -1;
    }

    public boolean validPalindrome(String s) {
        int res = check(s);
        if (res == -1) {
            return true;
        }
        return (check(s.substring(res, s.length() - res - 1)) == -1) ||
                (check(s.substring(res + 1, s.length() - res)) == -1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution19().validPalindrome("ab"));
    }
}
