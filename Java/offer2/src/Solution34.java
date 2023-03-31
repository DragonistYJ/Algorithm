import java.util.HashMap;

/**
 * @author 11214
 * @since 2023/3/31 14:22
 */
public class Solution34 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }

        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            String a = words[i];
            String b = words[i + 1];
            int len = Math.min(a.length(), b.length());
            boolean flag = false;
            for (int j = 0; j < len; j++) {
                int ca = orderArray[a.charAt(j) - 'a'];
                int cb = orderArray[b.charAt(j) - 'a'];
                if (cb < ca) {
                    return false;
                }
                if (ca < cb) {
                    flag = true;
                    break;
                }
            }
            if (!flag && a.length() > b.length()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution34().isAlienSorted(
                new String[]{"fxasxpc", "dfbdrifhp", "nwzgs", "cmwqriv", "ebulyfyve", "miracx", "sxckdwzv", "dtijzluhts", "wwbmnge", "qmjwymmyox"},
                "zkgwaverfimqxbnctdplsjyohu"));
    }
}
