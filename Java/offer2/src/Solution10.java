import java.util.HashMap;

/**
 * @author 11214
 * @since 2023/3/8 16:24
 */
public class Solution10 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += map.getOrDefault(sums[i] - k, 0);
            map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution10().subarraySum(new int[]{1, 1, 1}, 2);
    }
}
