import java.util.Arrays;
import java.util.HashSet;

/*
NO41 缺失的第一个正数
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) return 1;
        int max = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            max = Math.max(max, num);
            if (num > 0) hashSet.add(num);
        }
        for (int i = 1; i <= max; i++) {
            if (!hashSet.contains(i)) return i;
        }
        return hashSet.size() + 1;
    }

    public static void main(String[] args) {
        int[] x = {1,1};
        System.out.println(new Solution41().firstMissingPositive(x));
    }
}
