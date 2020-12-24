/*
NO125 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        String newS = s.replaceAll(" ", "").toLowerCase();
        int left = 0;
        int right = newS.length() - 1;
        while (left < right) {
            char leftChar = newS.charAt(left);
            if (!Character.isDigit(leftChar) && !Character.isLetter(leftChar)) {
                left += 1;
                continue;
            }
            char rightChar = newS.charAt(right);
            if (!Character.isDigit(rightChar) && !Character.isLetter(rightChar)) {
                right -= 1;
                continue;
            }
            if (leftChar != rightChar) return false;
            left += 1;
            right -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution125().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
