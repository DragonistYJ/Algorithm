/**
 * @ClassName Solution1025
 * @Author 11214
 * @Date 2020/4/25
 * @Description TODO
 */
public class Solution1025 {
    public boolean divisorGame(int N) {
        if (N == 1) return false;
        if (N == 2) return true;
        if (N == 3) return false;

        boolean[] ans = new boolean[N + 1];
        ans[1] = false;
        ans[2] = true;
        ans[3] = false;
        for (int i = 4; i <= N; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0 && !ans[i - j]) {
                    ans[i] = true;
                    break;
                }
            }
        }

        return ans[N];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1025().divisorGame(5));
    }
}
