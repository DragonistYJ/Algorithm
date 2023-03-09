/**
 * @author 11214
 * @since 2023/3/9 9:52
 */
public class Solution14 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a'] += 1;
        }
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length() - 1; i++) {
            count2[s2.charAt(i) - 'a'] += 1;
        }
        for (int i = s1.length() - 1; i < s2.length(); i++) {
            count2[s2.charAt(i) - 'a'] += 1;
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (count1[j] != count2[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            count2[s2.charAt(i - s1.length() + 1) - 'a'] -= 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution14().checkInclusion("ab", "eidboaoo"));
    }
}
