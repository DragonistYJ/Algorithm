/**
 * @author 11214
 * @since 2023/3/8 17:59
 */
public class Solution5 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] hashes = new int[n];
        for (int i = 0; i < words.length; i++) {
            int x = 0;
            for (int j = 0; j < words[i].length(); j++) {
                x = x | (1 << (words[i].charAt(j) - 'a'));
            }
            hashes[i] = x;
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((hashes[i] & hashes[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
