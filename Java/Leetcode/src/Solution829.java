/**
 * @ClassName Solution829
 * @Author 11214
 * @Date 2020/6/26
 * @Description 连续整数求和
 * 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 */
public class Solution829 {
    public int consecutiveNumbersSum(int N) {
        int range = (int) Math.sqrt(2 * N);
        int ans = 0;
        for (int i = 1; i <= range; i++) {
            int molecule = 2 * N - i * i - i;
            int denominator = 2 * i;
            if (molecule % denominator == 0 && molecule >= 0) ans += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution829().consecutiveNumbersSum(15));
    }
}
