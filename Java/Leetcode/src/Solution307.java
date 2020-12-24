/**
 * @ClassName Solution307
 * @Author 11214
 * @Date 2020/6/13
 * @Description 区域和检索—数组可修改
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 */
public class Solution307 {
    private static class NumArray {
        private int n;
        private int[] sums;

        public NumArray(int[] nums) {
            n = nums.length;
            sums = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }

        public void update(int i, int val) {
            int pre = sums[i + 1] - sums[i];
            int delta = val - pre;
            for (int j = i + 1; j <= n; j++) {
                sums[j] += delta;
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
