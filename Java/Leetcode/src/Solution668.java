/*
NO668 乘法表中第K小的数
几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 */
public class Solution668 {
    public int findKthNumber(int m, int n, int k) {
        int l = 1;
        int r = m * n;
        int nums = 0;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mid == l) break;
            nums = 0;
            for (int i = 1; i <= m; i++) {
                if (mid / i == 0) break;
                nums += Math.min(n, mid / i);
            }
            if (nums >= k) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution668().findKthNumber(3, 3, 5));
    }
}
