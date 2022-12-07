import java.util.Arrays;

/**
 * @author 11214
 * @since 2022/12/7 11:10
 * <p>
 * 给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
 * 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。
 * 如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 */
public class Solution1884 {
    public int twoEggDrop(int n) {
        int[] ans = new int[n + 1];
        Arrays.fill(ans, n + 10);
        ans[1] = 1;
        ans[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 碎
                int ans1 = j;
                // 没碎
                int ans2 = 1 + ans[i - j];
                ans[i] = Math.min(ans[i], Math.max(ans1, ans2));
            }
        }
        return ans[n];
    }

    public static void main(String[] args) {
        Solution1884 solution1884 = new Solution1884();
        int i = solution1884.twoEggDrop(100);
        System.out.println(i);
    }
}
