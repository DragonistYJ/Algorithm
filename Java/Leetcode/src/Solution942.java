import java.util.Arrays;

/**
 * @ClassName Solution942
 * @Author 11214
 * @Date 2020/5/21
 * @Description TODO
 */
public class Solution942 {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int[] ans = new int[n + 1];
        int max = n;
        int min = 0;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'D') {
                ans[i] = max;
                max -= 1;
            } else {
                ans[i] = min;
                min += 1;
            }
        }
        ans[n] = max;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution942().diStringMatch("DDI")));
    }
}
