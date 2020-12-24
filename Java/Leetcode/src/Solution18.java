import sun.java2d.pipe.AAShapePipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
NO18 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：
答案中不可以包含重复的四元组。
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> hashSet = new HashSet<>();
        int len = nums.length;
        if (len == 0) return ans;
        Arrays.sort(nums);

        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right -= 1;
                    } else if (sum < target) {
                        left += 1;
                    } else {
                        hashSet.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        left += 1;
                        right -= 1;
                    }
                }
            }
        }
        ans.addAll(hashSet);
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {1, 0, -1, 0, -2, 2};
        System.out.println(new Solution18().fourSum(x, 0));
    }
}
