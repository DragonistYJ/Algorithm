import java.lang.reflect.Array;
import java.util.Arrays;

/*
NO300 最长上升子序列
给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] lens = new int[len];
        Arrays.fill(lens, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lens[i] = Math.max(lens[i], lens[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i : lens) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution300().lengthOfLIS(x));
    }
}
