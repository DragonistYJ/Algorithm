/*
NO42 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Solution42 {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];

        left_max[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[right_max.length - 1] = height[height.length - 1];
        for (int i = right_max.length - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] h = new int[0];
        System.out.println(new Solution42().trap(h));
    }
}
