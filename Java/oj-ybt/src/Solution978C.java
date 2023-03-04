import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/3/4 15:09
 */
public class Solution978C {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        int[] nums = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            st.nextToken();
            nums[i] = (int) st.nval;
            max = Math.max(max, nums[i]);
        }
        int[] count = new int[max];
        for (int num : nums) {
            count[num] += 1;
        }
        int[] result = new int[max];
        for (int i = 1; i <= max; i++) {
            if (count[i] != 0) {
                for (int j = i; j <= max; j += i) {
                    result[j] += count[i];
                }
            }
        }

        for (int num : nums) {
            System.out.println(result[num] - 1);
        }
    }
}
