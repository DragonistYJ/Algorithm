import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
NO164 最大间距
给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
如果数组元素个数小于 2，则返回 0。
 */
public class Solution164 {
    private class Basket {
        public boolean used = false;
        public int maximum = 0;
        public int minimum = 200000000;
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int max = 0;
        int min = 200000000;
        int n = nums.length;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int basketSize = Math.max(1, (max - min) / (n - 1));
        int basketNum = (max - min) / basketSize + 1;
        List<Basket> baskets = new ArrayList<>(basketNum);
        for (int i = 0; i < basketNum; i++) {
            baskets.add(new Basket());
        }
        for (int num : nums) {
            int no = (num - min) / basketSize;
            Basket basket = baskets.get(no);
            basket.used = true;
            basket.maximum = Math.max(basket.maximum, num);
            basket.minimum = Math.min(basket.minimum, num);
        }
        int index = 0;
        while (index < baskets.size()) {
            if (!baskets.get(index).used) {
                baskets.remove(index);
                continue;
            }
            index += 1;
        }
        int ans = 0;
        for (int i = 0; i < baskets.size() - 1; i++) {
            Basket basket = baskets.get(i);
            ans = Math.max(ans, basket.maximum - basket.minimum);
            ans = Math.max(ans, baskets.get(i + 1).minimum - basket.maximum);
        }
        ans = Math.max(ans, baskets.get(baskets.size() - 1).maximum - baskets.get(baskets.size() - 1).minimum);
        return ans;
    }

    private class Solution164_2 {
        public int maximumGap(int[] nums) {
            if (nums.length < 2) return 0;

            Arrays.sort(nums);
            int gap = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                gap = Math.max(gap, nums[i + 1] - nums[i]);
            }
            return gap;
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3, 6, 9, 1};
        System.out.println(new Solution164().maximumGap(ints));
    }
}


