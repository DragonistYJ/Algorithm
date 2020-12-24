/**
 * @ClassName Solution303
 * @Author 11214
 * @Date 2020/4/27
 * @Description TODO
 */
class NumArray {
    private int len;
    private int[] nums;
    private int[] sums;

    public NumArray(int[] nums) {
        len = nums.length;
        this.nums = new int[len];
        this.sums = new int[len];
        if (len == 0) return;
        System.arraycopy(nums, 0, this.nums, 0, len);
        this.sums[0] = nums[0];
        for (int i = 1; i < len; i++) {
            this.sums[i] = nums[i] + this.sums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j] - sums[i] + nums[i];
    }
}

public class Solution303 {
    public static void main(String[] args) {
        int[] nums = new int[0];
        new NumArray(nums);
    }
}
