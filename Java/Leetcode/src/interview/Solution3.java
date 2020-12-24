package interview;

import java.util.HashSet;

/**
 * @ClassName Solution3
 * @Author 11214
 * @Date 2020/4/11
 * @Description 找出数组中重复的数字。
 *              在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 *              也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class Solution3 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return num;
            } else {
                hashSet.add(num);
            }
        }
        return -1;
    }
}
