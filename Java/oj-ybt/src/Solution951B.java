import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/2/5 15:14
 */
public class Solution951B {
    private static int n;
    private static int l;
    private static double[] nums;
    private static double[] sums;

    public static boolean check(double avg) {
        sums[0] = nums[0] - avg;
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i] - avg;
        }
        double min = sums[0];
        for (int i = l; i < n; i++) {
            min = Math.min(min, sums[i - l]);
            if (sums[i] - min >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        n = (int) st.nval;
        st.nextToken();
        l = (int) st.nval;
        nums = new double[n];
        sums = new double[n];
        double left = 0;
        double right = 0;
        for (int i = 0; i < n; i++) {
            st.nextToken();
            nums[i] = st.nval;
            right = Math.max(right, nums[i]);
        }
        while (right - left > 1e-5) {
            double mid = (right + left) / 2;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println((int) (left * 1000));
    }
}
