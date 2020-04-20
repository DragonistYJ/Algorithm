/*
NO84 柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int minHeight = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            minHeight = heights[i];
            ans = Math.max(ans, minHeight);
            for (int j = i + 1; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                ans = Math.max(ans, minHeight * (j - i + 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {2, 1, 5, 6, 2, 3};
        System.out.println(new Solution84().largestRectangleArea(x));
    }
}
