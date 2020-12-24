package interview;

/**
 * @ClassName Solution56_1
 * @Author 11214
 * @Date 2020/4/11
 * @Description TODO
 */
public class Solution56_1 {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int low = sum & (-sum);
        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & low) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
