/**
 * @author 11214
 * @since 2022/11/25 10:35
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 */
public class Solution342 {
    public boolean isPowerOfFour(int n) {
        return (n == 1) || (n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaab) == 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution342().isPowerOfFour(1));
    }
}
