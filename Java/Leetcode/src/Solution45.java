import java.util.Arrays;

/*
NO45 跳跃游戏2
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] steps = new int[n];
        Arrays.fill(steps, -1);
        steps[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            if (steps[i] != -1) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j >= n) break;
                    if (steps[i + j] == -1) steps[i + j] = steps[i] + 1;
                    else steps[i + j] = Math.min(steps[i + j], steps[i] + 1);
                }
            }
        }
        return steps[n - 1];
    }

    public static void main(String[] args) {
        int[] x = {2, 1};
        System.out.println(new Solution45().jump(x));
    }
}
