import java.util.HashMap;

/**
 * @ClassName Solution486
 * @Author 11214
 * @Date 2020/6/22
 * @Description 预测赢家
 * 给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 */
public class Solution486 {
    private HashMap<Integer, Integer> bounds;

    private int pick(int[] nums, int left, int right, int isFirst) {
        if (left == right) return nums[left] * isFirst;
        int bound = left * 100 + right;
        if (bounds.containsKey(bound))
            return bounds.get(bound);

        int a = nums[left] * isFirst + pick(nums, left + 1, right, -isFirst);
        int b = nums[right] * isFirst + pick(nums, left, right - 1, -isFirst);
        int ans = Math.max(a * isFirst, b * isFirst) * isFirst;
        bounds.put(left * 100 + right, ans);
        return ans;
    }

    public boolean PredictTheWinner(int[] nums) {
        bounds = new HashMap<>();
        return pick(nums, 0, nums.length-1, 1) >= 0;
    }
}
