/**
 * @author 11214
 * @since 2023/3/7 20:00
 */
public class Solution1 {
    private long fastMultiply(long a, long b) {
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return b;
        }
        long sig = a & 1;
        long base = sig == 1 ? b : 0;
        long res = fastMultiply(a >> 1, b + b);
        return base + res;
    }

    private long binarySearch(long a, long b) {
        long l = 0;
        long r = a;
        while (l < r) {
            long mid = (l + r) >> 1;
            long x = fastMultiply(mid, b);
            if (x <= a && x + b > a) {
                return mid;
            }
            if (x <= a && x + b <= a) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int divide(int a, int b) {
        long sig = ((long) a * (long) b) < 0 ? -1 : 1;
        long aa = a < 0 ? -((long) a) : (long) a;
        long bb = b < 0 ? -((long) b) : (long) b;
        long res = binarySearch(aa, bb) * sig;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().divide(-2147483648, -1));
    }
}
