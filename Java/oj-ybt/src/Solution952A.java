import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author 11214
 * @since 2023/2/13 18:16
 */
public class Solution952A {
    private static int n;
    private static int sum;
    private static int[] numbers;
    private static boolean[] visited;

    public static boolean dfs(int upper, int complete, int curr) {
        if (complete * upper == sum) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int t = curr + numbers[i];
            if (t > upper) {
                break;
            }
            visited[i] = true;
            boolean result = dfs(upper, t == upper ? complete + 1 : complete, t == upper ? 0 : t);
            visited[i] = false;
            if (result) {
                return true;
            }
            if (i == n) {
                return false;
            }
            while (i + 1 < n && numbers[i] == numbers[i + 1]) {
                i += 1;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        n = (int) st.nval;
        numbers = new int[n];
        visited = new boolean[n];
        sum = 0;
        for (int i = 0; i < n; i++) {
            st.nextToken();
            numbers[i] = (int) st.nval;
            sum += numbers[i];
        }
        Arrays.sort(numbers);
        for (int i = 0; i <= n / 2; i++) {
            int t = numbers[i];
            numbers[i] = numbers[n - i - 1];
            numbers[n - i - 1] = t;
        }
        for (int i = n; i >= 1; i--) {
            if (sum % i != 0) {
                continue;
            }
            int upper = sum / i;
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (numbers[j] > upper) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            if (dfs(upper, 0, 0)) {
                System.out.println(upper);
                return;
            }
        }
    }
}
