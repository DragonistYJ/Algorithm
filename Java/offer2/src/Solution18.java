/**
 * @author 11214
 * @since 2023/3/10 9:58
 */
public class Solution18 {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                i += 1;
            }
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j -= 1;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution18().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
