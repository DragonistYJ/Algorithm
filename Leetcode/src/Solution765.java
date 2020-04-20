/*
NO765 情侣牵手
N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 */
public class Solution765 {
    public int minSwapsCouples(int[] row) {
        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int other;
            if (row[i] % 2 == 0) {
                other = row[i] + 1;
            } else {
                other = row[i] - 1;
            }
            if (row[i + 1] == other) continue;

            int index = 0;
            for (int j = i + 1; j < row.length; j++) {
                if (row[j] == other) {
                    index = j;
                    break;
                }
            }
            int tmp = row[i + 1];
            row[i + 1] = other;
            row[index] = tmp;
            ans += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {3, 2, 0, 1};
        System.out.println(new Solution765().minSwapsCouples(x));
    }
}
