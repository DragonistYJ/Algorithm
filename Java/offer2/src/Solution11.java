import java.util.HashMap;

/**
 * @author 11214
 * @since 2023/3/8 16:34
 */
public class Solution11 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(sums[i])) {
                ans = Math.max(ans, i - map.get(sums[i]));
            } else {
                map.put(sums[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution11().findMaxLength(new int[]{0, 0, 0, 1, 1}));
    }
}
