import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/2/7 11:16
 */
public class Solution951D {
    private static int m;
    private static int[] numbers;

    public static boolean check(int max) {
        int temp = 0;
        int group = 1;
        for (int number : numbers) {
            if (temp + number <= max) {
                temp += number;
            } else {
                temp = number;
                if (number > max) {
                    return false;
                }
                group += 1;
            }
        }
        return group <= m;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        m = (int) st.nval;
        numbers = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            st.nextToken();
            numbers[i] = (int) st.nval;
            sum += numbers[i];
        }

        int left = 0;
        int right = sum;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(right);
    }
}
