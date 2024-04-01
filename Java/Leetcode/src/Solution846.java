import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yujian
 * @since 2023/7/20 11:54
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌上的数值。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 */
public class Solution846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(hand[i])) {
                continue;
            }
            for (int j = hand[i]; j < hand[i] + groupSize; j++) {
                if (!map.containsKey(j)) {
                    return false;
                }
                map.put(j, map.get(j) - 1);
                if (map.get(j) == 0) {
                    map.remove(j);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution846 solution = new Solution846();
        System.out.println(solution.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
    }
}
