/*
NO440 字典序第K小数字
给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
注意：1 ≤ k ≤ n ≤ 109。
 */
public class Solution440 {
    public int findKthNumber(int n, int k) {
        return search(0, 0, n, k);
    }

    private int search(int prefix, int addUp, int n, int k) {
        if (addUp == k) return prefix;
        int sum = addUp;
        int index = 0;
        if (prefix == 0) index = 1;
        for (int i = index; i < 10; i++) {
            int tmp = fitByBit(prefix, i, n);
            if (sum + tmp < k) {
                sum += tmp;
            } else {
                return search(prefix * 10 + i, sum + 1, n, k);
            }
        }
        return prefix;
    }

    private int fitByBit(int prefix, int number, int n) {
        int sum = 0;
        long tmp = prefix * 10 + number;
        long suffix = 1;
        while (tmp <= n) {
            if (tmp + suffix <= n) {
                sum += suffix;
            } else {
                sum += n - tmp + 1;
            }
            tmp *= 10;
            suffix *= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution440().findKthNumber(10000, 10000));
    }
}
