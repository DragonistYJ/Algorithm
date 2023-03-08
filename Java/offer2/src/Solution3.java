/**
 * @author 11214
 * @since 2023/3/7 19:57
 */
public class Solution3 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        if (n == 0) {
            return ans;
        }
        for (int i = 1; i <= n; i++) {
            int x = (int) Math.pow(2, (int) (Math.log(i) / Math.log(2)));
            ans[i] = ans[i - x] + 1;
        }
        return ans;
    }
}
