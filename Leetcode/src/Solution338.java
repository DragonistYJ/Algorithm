import java.util.Arrays;

/*
NO338 比特位计数
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class Solution338 {
    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        if (num == 1) return new int[]{0, 1};
        int[] bits = new int[num + 1];
        bits[0] = 0;
        bits[1] = 1;
        int mod = 2;
        for (int i = 2; i <= num; i++) {
            if (i == mod * 2) mod *= 2;
            bits[i] = bits[i % mod] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution338().countBits(5)));
    }
}
