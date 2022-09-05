import java.util.Arrays;

/**
 * @author yujian
 * @since 2022/9/5 16:11
 * 有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。
 * 在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。
 * 注意，操作执行后，某些盒子中可能会存在不止一个小球。
 * 返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。
 * 每个 answer[i] 都需要根据盒子的 初始状态 进行计算。
 */
public class Solution1769 {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] leftNums = new int[n];
        int[] rightNums = new int[n];
        int total = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                total += 1;
                sum += i;
            }
        }
        leftNums[0] = boxes.charAt(0) == '1' ? 1 : 0;
        rightNums[0] = total - leftNums[0];
        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                leftNums[i] = leftNums[i - 1] + 1;
                rightNums[i] = rightNums[i - 1] - 1;
            } else {
                leftNums[i] = leftNums[i - 1];
                rightNums[i] = rightNums[i - 1];
            }
        }
        int[] ans = new int[n];
        ans[0] = sum;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] - rightNums[i - 1] + leftNums[i - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1769().minOperations("001011")));
    }
}
