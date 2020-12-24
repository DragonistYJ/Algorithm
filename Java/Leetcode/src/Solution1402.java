import java.util.Arrays;

/**
 * @ClassName Solution1402
 * @Author 11214
 * @Date 2020/4/25
 * @Description TODO
 */
public class Solution1402 {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int index = 0;
        while (index < n && satisfaction[index] < 0) index += 1;
        if (index == n) return 0;
        int sum = 0;
        int positive = 0;
        for (int i = index; i < n; i++) {
            sum += satisfaction[i] * (i - index + 1);
            positive += satisfaction[i];
        }

        int negative = 0;
        int sum2 = 0;
        int i;
        for (i = index - 1; i >= 0; i--) {
            negative += satisfaction[i];
            sum2 += negative;
            if (negative + positive < 0) {
                sum2 -= negative;
                i += 1;
                break;
            }
        }

        if (i < 0) i = 0;
        return sum2 + sum + positive * (index - i);
    }

    public static void main(String[] args) {
        int[] nums = {-1, -4, -5};
        System.out.println(new Solution1402().maxSatisfaction(nums));
    }
}
